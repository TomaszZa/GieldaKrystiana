package com.capgemini.MarketPlay.Player;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.MarketPlay.Main.DateController;
import com.capgemini.MarketPlay.Market.DataToStartegyTransport;
import com.capgemini.MarketPlay.Strategies.FallingStrategy;
import com.capgemini.MarketPlay.Strategies.GrowingStrategy;
import com.capgemini.MarketPlay.Strategies.NoChangingStrategy;
import com.capgemini.MarketPlay.Strategies.Strategy;
import com.capgemini.MarketPlay.Strategies.ToBuyAndSellWithMarketTransport;
import com.capgemini.MarketPlay.View.ChoosenStrategy;
import com.capgemini.MarketPlayer.MarketOffice.MarketOffice;

//REFACTOR
public class Player {
	private MarketOffice marketOffice;
	private Strategy strategy;
	private PlayerData playerData;
	private DataToStartegyTransport dataToStrategy;
	private DateController dateController;

	public Player(String playerName) {
		playerData = new PlayerData();
		playerData.setPlayerName(playerName);
		this.marketOffice = new MarketOffice();
	}

	public void takeNeededData() {
		marketOffice.takeAndChangeDate();

		dataToStrategy = marketOffice.getDataToStrategy();

		Double accountState = playerData.getPlayerAccountState();
		List<String> actionsNames = playerData.getPlayerNameActions();
		List<Long> actionsNumbers = playerData.getPlayerNumberActions();

		dataToStrategy.setPlayerAccountState(accountState);
		dataToStrategy.setPlayerNameActions(actionsNames);
		dataToStrategy.setPlayerNumberActions(actionsNumbers);
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
		ToBuyAndSellWithMarketTransport toBuyAndSellFromMarket = strategy.checkMovesInStrategy(dataToStrategy);
		Double accountState = playerData.getPlayerAccountState();
		Double outcome = 0.0;
		Double income = 0.0;

		marketOffice.buyAndSell(toBuyAndSellFromMarket);
		List<String> boughtActionsNames = toBuyAndSellFromMarket.getNameOfBoughtActions();
		playerData.setPlayerNameActions(boughtActionsNames);

		outcome = calculatingBought(toBuyAndSellFromMarket);
		income = calculatingSold(toBuyAndSellFromMarket);

		accountState = accountState + income - outcome;

	}

	private Double calculatingBought(ToBuyAndSellWithMarketTransport toBuyAndSellFromMarket) {
		List<Long> boughtActionsEmount = toBuyAndSellFromMarket.getNumberOfBoughtActions();
		List<Double> priceForOneBoughtActions = toBuyAndSellFromMarket.getPriceForOneBoughtAction();
		List<Double> playerValueOfActions = new ArrayList<Double>();
		Double value;
		Double outcome = 0.0;

		playerData.setPlayerNumberActions(boughtActionsEmount);
		playerData.setPlayerValueOfActions(playerValueOfActions);

		for (int i = 0; i < boughtActionsEmount.size(); i++) {
			value = boughtActionsEmount.get(i) * priceForOneBoughtActions.get(i);
			outcome = outcome + value;
			playerValueOfActions.set(i, value);
		}
		return outcome;
	}

	private Double calculatingSold(ToBuyAndSellWithMarketTransport toBuyAndSellFromMarket) {
		List<Double> priceForOneSoldActions = toBuyAndSellFromMarket.getPriceForOneSoldActions();
		List<Long> soldActionsEmount = toBuyAndSellFromMarket.getNumberOfSoldtActions();
		Double income = 0.0;

		for (int i = 0; i < soldActionsEmount.size(); i++) {
			income = income + priceForOneSoldActions.get(i) * soldActionsEmount.get(i);
		}
		return income;
	}

	public MarketOffice getMarketOffice() {
		return marketOffice;
	}

	public void setMarketOffice(MarketOffice marketOffice) {
		this.marketOffice = marketOffice;
	}

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public PlayerData getPlayerData() {
		return playerData;
	}

	public void setPlayerData(PlayerData playerData) {
		this.playerData = playerData;
	}

	public DataToStartegyTransport getDataToStrategy() {
		return dataToStrategy;
	}

	public void setDataToStrategy(DataToStartegyTransport dataToStrategy) {
		this.dataToStrategy = dataToStrategy;
	}

	public DateController getDateController() {
		return dateController;
	}

	public void setDateController(DateController dateController) {
		this.dateController = dateController;
	}
}
