package io.api.CoronavirusTracker.services;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.api.CoronavirusTracker.models.CoronavirusDataEntity;

@Service
public class CoronavirusDataService {

	//@Value("api.url")
	private String url = "https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats";

	@PostConstruct
	public CoronavirusDataEntity fetchUpdatedData() {
		System.out.println("fetchUpdatedData(+)");

		final HttpHeaders headers = new HttpHeaders();
		headers.set("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com");
		headers.set("x-rapidapi-key", "d76c71ddd8msh381574bbf1fe6e8p1d0357jsn6097cb2718f0");

		final HttpEntity<String> entity = new HttpEntity<String>(headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<CoronavirusDataEntity> responseEntity = restTemplate
				.exchange(url, HttpMethod.GET, entity, CoronavirusDataEntity.class);
		
		System.out.println("responseEntity: "+responseEntity);
		
		CoronavirusDataEntity response = responseEntity.getBody();
		
		System.out.println("fetchUpdatedData(-)");
		return response;
	}

}
