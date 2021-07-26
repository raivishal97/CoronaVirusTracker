package io.api.CoronavirusTracker.controllers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.api.CoronavirusTracker.models.CoronavirusDataEntity;
import io.api.CoronavirusTracker.models.DetailedData;
import io.api.CoronavirusTracker.services.CoronavirusDataService;

@Controller
public class ApiController {

	@Autowired
	private CoronavirusDataService coronavirusDataService;

	@GetMapping("/")
	public String getUpdatedDetails(Model model) {
		CoronavirusDataEntity coronavirusDataEntity =  coronavirusDataService.fetchUpdatedData();
		String lastCheckedDate = coronavirusDataEntity.getData().getLastChecked();
		DetailedData[] detailedDatas = coronavirusDataEntity.getData().getCovid19Stats();

		List<DetailedData> detailedDataList = Arrays.asList(detailedDatas)
				.stream()
				.filter( data -> data.getConfirmed() > 0)
				.sorted(Comparator.comparingInt(DetailedData::getConfirmed).reversed())
				.collect(Collectors.toList());

		long totalCount = Arrays.asList(detailedDatas)
				.stream()
				.mapToInt(data ->  data.getConfirmed())
				.sum();

		long totalDeathToll = Arrays.asList(detailedDatas)
				.stream()
				.mapToInt(data ->  data.getDeaths())
				.sum();
		
		model.addAttribute("lastCheckedDate", lastCheckedDate);
		model.addAttribute("detailedDataList", detailedDataList);
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("totalDeathToll", totalDeathToll);

		return "home";
	}


}
