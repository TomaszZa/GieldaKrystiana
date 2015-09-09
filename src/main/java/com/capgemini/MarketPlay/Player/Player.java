package com.capgemini.MarketPlay.Player;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.MarketPlay.Market.DataToStartegy;
import com.capgemini.MarketPlay.Strategies.FallingStrategy;
import com.capgemini.MarketPlay.Strategies.GrowingStrategy;
import com.capgemini.MarketPlay.Strategies.NoChangingStrategy;
import com.capgemini.MarketPlay.Strategies.Strategy;
import com.capgemini.MarketPlay.Strategies.ToBuyAndSellWithMarket;
import com.capgemini.MarketPlay.View.ChoosenStrategy;
import com.capgemini.MarketPlayer.MarketOffice.MarketOffice;

public class Player {
	private MarketOffice marketOffice;
	private Strategy strategy;
	private PlayerData playerData;
	private DataToStartegy dataToStrategy;

	public Player(String playerName) {
		playerData = new PlayerData();
		playerData.setPlayerName(playerName);
		this.marketOffice = new MarketOffice();
	}

	public void takeNeededDate() {
		marketOffice.takeAndChangeDate();
		dataToStrategy = marketOffice.getDataToStrategy();
		dataToStrategy.setPlayerAccountState(playerData.getPlayerAccountState());
		dataToStrategy.setPlayerNameActions(playerData.getPlayerNameActions());
		dataToStrategy.setPlayerNumberActions(playerData.getPlayerNumberActions());
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
		ToBuyAndSellWithMarket toBuyAndSellFromMarket = strategy.checkMovesInStrategy(dataToStrategy);
		List<Double> priceForOneBoughtActions = toBuyAndSellFromMarket.getPriceForOneBoughtAction();
		List<Double> priceForOneSoldActions = toBuyAndSellFromMarket.getPriceForOneSoldActions();

		List<Double> playerValueOfActions = new ArrayList<Double>();
		Double accountState = playerData.getPlayerAccountState();
		Double value;
		Double outcome = 0.0;
		Double income = 0.0;

		marketOffice.buyAndSell(toBuyAndSellFromMarket);

		playerData.setPlayerNameActions(toBuyAndSellFromMarket.getNameOfBoughtActions());
		playerData.setPlayerNumberActions(toBuyAndSellFromMarket.getNumberOfBoughtActions());

		for (int i = 0; i < playerData.getPlayerNumberActions().size(); i++) {
			value = playerData.getPlayerNumberActions().get(i) * priceForOneBoughtActions.get(i);
			outcome = outcome + value;
			playerValueOfActions.set(i, value);
		}
		for (Double price : priceForOneSoldActions) {
			income = income + price;
		}
		accountState = accountState + income - outcome;
		playerData.setPlayerValueOfActions(playerValueOfActions);
	}

}
