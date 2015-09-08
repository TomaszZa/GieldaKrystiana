package com.capgemini.MarketPlay.Market;

import java.util.HashMap;

public class Company {
	private String name;
	private Double todayPrice;
	private Double growPoint;
	private HashMap<String, Double> prices = new HashMap<>();

	public Company(String name, Double todayPrice, String date) {
		this.name = name;
		this.todayPrice = todayPrice;
		prices.put(date, todayPrice);
		countGrowPoint();
	}

	// jak juz jest spolka to to
	public void addNewPrice(Double todayPrice, String date) {
		this.todayPrice = todayPrice;
		prices.put(date, todayPrice);
		countGrowPoint();
	}

	// moglo by byc tez dla ilu dni
	private void countGrowPoint() {
		Double result = new Double(0.0);
		Long numberOfDays = new Long(prices.size());
		for (String key : prices.keySet()) {
			result += prices.get(key) / numberOfDays;
		}
		growPoint = result;
	}

	// getters/setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getTodayPrice() {
		return todayPrice;
	}

	public void setTodayPrice(Double todayPrice) {
		this.todayPrice = todayPrice;
	}

	public Double getGrowPoint() {
		return growPoint;
	}

	public void setGrowPoint(Double growPoint) {
		this.growPoint = growPoint;
	}

	// do contains potrzebne metody equals i hasCode:
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (!(o instanceof Company))
			return false;

		Company other = (Company) o;
		return this.name.equals(other.name);
	}

	public int hashCode() {
		return name.hashCode();
	}

}
