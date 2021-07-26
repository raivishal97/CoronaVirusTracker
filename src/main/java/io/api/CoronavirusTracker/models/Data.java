package io.api.CoronavirusTracker.models;

import java.util.Arrays;

public class Data {
	private String lastChecked;
	private DetailedData[] covid19Stats;
	public String getLastChecked() {
		return lastChecked;
	}
	public void setLastChecked(String lastChecked) {
		this.lastChecked = lastChecked;
	}
	public DetailedData[] getCovid19Stats() {
		return covid19Stats;
	}
	public void setCovid19Stats(DetailedData[] covid19Stats) {
		this.covid19Stats = covid19Stats;
	}
	@Override
	public String toString() {
		return "Data [lastChecked=" + lastChecked + ", covid19Stats=" + Arrays.toString(covid19Stats) + "]";
	}
}
