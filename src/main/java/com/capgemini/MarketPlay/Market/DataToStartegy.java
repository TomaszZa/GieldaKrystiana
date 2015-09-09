package com.capgemini.MarketPlay.Market;

import java.util.List;

public class DataToStartegy {

	private List<String> nameActions;
	private List<Double> todayPriceForActions;
	private List<Double> growPoints;
	private Double playerAccountState;
	private List<String> playerNameActions;
	private List<Long> playerNumberActions;

	public DataToStartegy(List<String> nameActions, List<Double> todayPriceForActions, List<Double> growPoints) {

		this.nameActions = nameActions;
		this.todayPriceForActions = todayPriceForActions;
		this.growPoints = growPoints;
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

	public Double getPlayerAccountState() {
		return playerAccountState;
	}

	public void setPlayerAccountState(Double playerAccountState) {
		this.playerAccountState = playerAccountState;
	}

	public List<String> getPlayerNameActions() {
		return playerNameActions;
	}

	public void setPlayerNameActions(List<String> playerNameActions) {
		this.playerNameActions = playerNameActions;
	}

	public List<Long> getPlayerNumberActions() {
		return playerNumberActions;
	}

	public void setPlayerNumberActions(List<Long> playerNumberActions) {
		this.playerNumberActions = playerNumberActions;
	}

}
