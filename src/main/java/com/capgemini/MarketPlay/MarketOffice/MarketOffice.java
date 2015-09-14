package com.capgemini.MarketPlay.MarketOffice;

import java.util.List;

import com.capgemini.MarketPlay.Market.DataToStartegyTransport;
import com.capgemini.MarketPlay.Market.Market;
import com.capgemini.MarketPlay.Strategies.ToBuyAndSellWithMarketTransport;

public class MarketOffice {
	private final float buyingTax = 0.5f;
	private DataToStartegyTransport dataToStrategy;
	private Market market;

	public MarketOffice() {
		market = new Market();
	}

	public DataToStartegyTransport takeAndChangeDate() { // obczaic czy
															// zmienia!!!!!!!
		List<Double> todayPriceForActions;

		dataToStrategy = market.getRecentDataToStrategy();

		todayPriceForActions = dataToStrategy.getTodayPriceForActions();
		for (Double price : todayPriceForActions) {
			price += buyingTax * price;
		}
		return dataToStrategy;
	}

	public DataToStartegyTransport getDataToStrategy() {
		return dataToStrategy;
	}

	public void buyAndSell(ToBuyAndSellWithMarketTransport actions) {
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
