package com.capgemini.MarketPlayer.MarketOffice;

import java.util.List;

import com.capgemini.MarketPlay.Market.DataToStartegy;
import com.capgemini.MarketPlay.Market.Market;
import com.capgemini.MarketPlay.Strategies.ToBuyFromMarket;

public class MarketOffice {
	private final float buyingTax = 0.5f;
	private DataToStartegy dataToStrategy;
	String todayDate;

	private Market market = new Market(todayDate);

	public MarketOffice(String todayDate) {
		this.todayDate = todayDate;
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

	public void buy(ToBuyFromMarket actions) {
		market.buy(actions);
		List<Double> actionsPrices = actions.getPriceForOneBoughtAction();
		for (Double price : actionsPrices) {
			price += price * buyingTax;
		}
	}

}
