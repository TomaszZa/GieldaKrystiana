package com.capgemini.MarketPlay.Player;

import java.util.List;

import com.capgemini.MarketPlay.Market.DataToStartegy;
import com.capgemini.MarketPlay.Strategies.FallingStrategy;
import com.capgemini.MarketPlay.Strategies.GrowingStrategy;
import com.capgemini.MarketPlay.Strategies.NoChangingStrategy;
import com.capgemini.MarketPlay.Strategies.Strategy;
import com.capgemini.MarketPlay.Strategies.ToBuyFromMarket;
import com.capgemini.MarketPlay.View.ChoosenStrategy;
import com.capgemini.MarketPlayer.MarketOffice.MarketOffice;

public class Player {
	private String playerName;
	private Long playerAccountState = 10000L;
	private List<String> playerNameActions;
	private List<Long> playerNumberActions;
	private List<Double> playerValueOfActions;
	private DataToStartegy dataToStrategy;
	private String todayDate; // to dodac chyba z maina ?(cos ma generowac te
								// daty)

	private MarketOffice marketOffice;
	Strategy strategy;

	public Player(String playerName, String date) {
		this.setPlayerName(playerName);
		this.todayDate = date;
		marketOffice = new MarketOffice(todayDate);
	}

	public void takeNeededDate() {
		marketOffice.takeAndChangeDate();
		dataToStrategy = marketOffice.getDataToStrategy();
	}

	public void choosenStrategy(ChoosenStrategy choosenStrategy) {

		switch (choosenStrategy) {
		case GROWING_STRATEGY:
			strategy = new GrowingStrategy();
			break;
		case FALLING_STRATEGY:
			strategy = new FallingStrategy();
			break;
		case NO_CHANGING_STARTEGY:
			strategy = new NoChangingStrategy();
			break;
		}
	}

	public void realizeTrade() {
		ToBuyFromMarket toBuyFromMarket;
		toBuyFromMarket = strategy.checkMovesInStrategy(dataToStrategy);
		marketOffice.buy(toBuyFromMarket);
		playerNameActions = toBuyFromMarket.getNameOfBoughtActions();
		playerNumberActions = toBuyFromMarket.getNumberOfBoughtActions();
		List<Double> priceForOneBoughtActions = toBuyFromMarket.getPriceForOneBoughtAction();
		Double value;

		for (int i = 0; i < playerNumberActions.size(); i++) {
			value = playerNumberActions.get(i) * priceForOneBoughtActions.get(i);
			playerValueOfActions.set(i, value);
		}
	}

	// getters/setters

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public Long getPlayerAccountState() {
		return playerAccountState;
	}

	public void setPlayerAccountState(Long playerAccountState) {
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

	public List<Double> getPlayerPriceActions() {
		return playerValueOfActions;
	}

	public void setPlayerPriceActions(List<Double> playerPriceActions) {
		this.playerValueOfActions = playerPriceActions;
	}

}
