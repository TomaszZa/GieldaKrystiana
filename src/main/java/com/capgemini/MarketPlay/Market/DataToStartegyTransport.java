package com.capgemini.MarketPlay.Market;

import java.util.List;

public class DataToStartegyTransport {

	private List<String> nameActions;
	private List<Double> todayPriceForActions;
	private List<Double> growPoints;
	private Double playerAccountState;
	private List<String> playerOwnNameActions;
	private List<Long> playerOwnNumberActions;

	public DataToStartegyTransport(List<String> nameActions, List<Double> todayPriceForActions, List<Double> growPoints) {

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
		return playerOwnNameActions;
	}

	public void setPlayerNameActions(List<String> playerNameActions) {
		this.playerOwnNameActions = playerNameActions;
	}

	public List<Long> getPlayerNumberActions() {
		return playerOwnNumberActions;
	}

	public void setPlayerNumberActions(List<Long> playerNumberActions) {
		this.playerOwnNumberActions = playerNumberActions;
	}

}
