package com.capgemini.MarketPlay.Player;

import java.util.List;

public class PlayerData {
	private String playerName;
	private Double playerAccountState = 10000.0;
	private List<String> playerNameActions;
	private List<Long> playerNumberActions;
	private List<Double> playerValueOfActions;

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
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

	public List<Double> getPlayerValueOfActions() {
		return playerValueOfActions;
	}

	public void setPlayerValueOfActions(List<Double> playerPriceActions) {
		this.playerValueOfActions = playerPriceActions;
	}

}
