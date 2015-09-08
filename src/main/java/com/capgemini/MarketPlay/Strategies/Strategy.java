package com.capgemini.MarketPlay.Strategies;

import com.capgemini.MarketPlay.Market.DataToStartegy;

public interface Strategy {

	public ToBuyFromMarket checkMovesInStrategy(DataToStartegy date);

}
