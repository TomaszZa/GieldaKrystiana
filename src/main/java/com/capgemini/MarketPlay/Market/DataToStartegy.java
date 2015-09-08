package com.capgemini.MarketPlay.Market;

import java.util.List;

public class DataToStartegy {

	private List<String> nameActions;
	private List<Double> todayPriceForActions;
	private List<Double> growPoints;

	public DataToStartegy(List<String> nameActions, List<Double> todayPriceForActions, List<Double> growPoint) {
		this.nameActions = nameActions;
		this.todayPriceForActions = todayPriceForActions;
		this.growPoints = growPoint;
	}

	public List<String> getNameActions() {
		return nameActions;
	}

	public void setNameActions(List<String> nameActions) {
		this.nameActions = nameActions;
	}

	public List<Double> getTodayPriceForActions() {
		return todayPriceForActions;
	}

	public void setTodayPriceForActions(List<Double> todayPriceForActions) {
		this.todayPriceForActions = todayPriceForActions;
	}

	public List<Double> getGrowPoint() {
		return growPoints;
	}

	public void setGrowPoint(List<Double> growPoint) {
		this.growPoints = growPoint;
	}
}
