package com.capgemini.MarketPlay.Strategies;

import com.capgemini.MarketPlay.Market.DataToStartegyTransport;

public class FallingStrategy implements Strategy {
	final String strategyName = "FallingStrategy";

	@Override
	public ToBuyAndSellWithMarketTransport checkMovesInStrategy(DataToStartegyTransport date) {
		// TODO Auto-generated method stub
		return null;
	}

	public int hashCode() {
		return strategyName.hashCode();
	}
}
