package com.capgemini.MarketPlay.Strategies;

import com.capgemini.MarketPlay.Market.DataToStartegyTransport;

public class GrowingStrategy implements Strategy {
	private final String strategyName = "GrowingStrategy";

	@Override
	public ToBuyAndSellWithMarketTransport checkMovesInStrategy(DataToStartegyTransport date) {
		// TODO Auto-generated method stub
		return null;
	}

	public int hashCode() {
		return strategyName.hashCode();
	}
}
