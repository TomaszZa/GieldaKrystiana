package com.capgemini.MarketPlay.Strategies;

import com.capgemini.MarketPlay.Market.DataToStartegyTransport;

public interface Strategy {

	public ToBuyAndSellWithMarketTransport checkMovesInStrategy(DataToStartegyTransport date);

}
