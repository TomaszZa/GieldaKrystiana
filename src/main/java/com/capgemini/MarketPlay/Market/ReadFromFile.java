package com.capgemini.MarketPlay.Market;

import java.util.List;

public class ReadFromFile {
	private List<String> companyName;
	private List<String> date;// ma byc w formacie rok-miesiac-dzien
	private List<Double> price;

	public ReadFromFile() {
		readAllCompanysFromFile();
	}

	private void readAllCompanysFromFile() {
		// tu czytanie z pliku
	}

	public List<String> getCompanyName() {
		return companyName;
	}

	public List<String> getDate() {
		return date;
	}

	public List<Double> getPrice() {
		return price;
	}
}
