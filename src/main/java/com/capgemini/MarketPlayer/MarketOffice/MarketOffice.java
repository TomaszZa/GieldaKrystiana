package com.capgemini.MarketPlayer.MarketOffice;

import java.util.List;

import com.capgemini.MarketPlay.Market.DataToStartegy;
import com.capgemini.MarketPlay.Market.Market;
import com.capgemini.MarketPlay.Strategies.ToBuyAndSellWithMarket;

public class MarketOffice {
	private final float buyingTax = 0.5f;
	private DataToStartegy dataToStrategy;
	String todayDate;

	private Market market = new Market();

	public MarketOffice() {
	}

	public void takeAndChangeDate() { // obczaic czy zmienia!!!!!!!
		List<Double> todayPriceForActions;

		dataToStrategy = market.getRecentDataToStrategy();

		todayPriceForActions = dataToStrategy.getTodayPriceForActions();
		for (Double price : todayPriceForActions) {
			price += buyingTax * price;
		}
	}

	public DataToStartegy getDataToStrategy() {
		return dataToStrategy;
	}

	public void buyAndSell(ToBuyAndSellWithMarket actions) {
		market.buyAndSell(actions);
		List<Double> boughtActionsPrices = actions.getPriceForOneBoughtAction();
		List<Double> soldActionsPrices = actions.getPriceForOneSoldActions();

		for (Double price : boughtActionsPrices) {
			price += price * buyingTax;
		}
		for (Double price : soldActionsPrices) {
			price -= price * buyingTax;
		}

	}

}
