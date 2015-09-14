package com.capgemini.MarketPlay.Player;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.capgemini.MarketPlay.Market.DataToStartegyTransport;
import com.capgemini.MarketPlay.Strategies.FallingStrategy;
import com.capgemini.MarketPlay.Strategies.GrowingStrategy;
import com.capgemini.MarketPlay.Strategies.NoChangingStrategy;
import com.capgemini.MarketPlay.Strategies.Strategy;
import com.capgemini.MarketPlay.Strategies.ToBuyAndSellWithMarketTransport;
import com.capgemini.MarketPlay.View.ChoosenStrategy;
import com.capgemini.MarketPlayer.MarketOffice.MarketOffice;

public class PlayerTest {

	@Test
	public void testTakeNeededDataIfAddDateToTransportClassProperli() {
		Player player = new Player("Gracz");
		DataToStartegyTransport transportClass = new DataToStartegyTransport(null, null, null);
		// mock MarketOffice
		MarketOffice mockMarketOffice = Mockito.mock(MarketOffice.class);
		Mockito.doReturn(transportClass).when(mockMarketOffice).getDataToStrategy();

		player.setMarketOffice(mockMarketOffice);

		// Mock PlayerData
		PlayerData mockPlayerData = Mockito.mock(PlayerData.class);
		Mockito.doReturn(new Double(200.0)).when(mockPlayerData).getPlayerAccountState();

		List<String> actionsNames = new ArrayList<String>();
		List<Long> actionsNumbers = new ArrayList<Long>();
		actionsNames.add("A");
		actionsNumbers.add(new Long(20));
		Mockito.doReturn(actionsNames).when(mockPlayerData).getPlayerNameActions();
		Mockito.doReturn(actionsNumbers).when(mockPlayerData).getPlayerNumberActions();

		player.setPlayerData(mockPlayerData);

		player.takeNeededData();

		assertEquals("A", transportClass.getPlayerNameActions().get(0));
		assertEquals(new Double(200.0), transportClass.getPlayerAccountState());
		assertEquals(new Long(20), transportClass.getPlayerNumberActions().get(0));

	}

	@Test
	public void testChoosenStrategyIfStrategyIsChooseProperly() {
		Player player = new Player("Gracz");

		ChoosenStrategy wyliczenie = ChoosenStrategy.FALLING_STRATEGY;
		ChoosenStrategy wyliczenie1 = ChoosenStrategy.GROWING_STRATEGY;
		ChoosenStrategy wyliczenie2 = ChoosenStrategy.NO_CHANGING_STARTEGY;

		player.choosenStrategy(wyliczenie);
		Strategy strategy = player.getStrategy();

		player.choosenStrategy(wyliczenie1);
		Strategy strategy1 = player.getStrategy();

		player.choosenStrategy(wyliczenie2);
		Strategy strategy2 = player.getStrategy();

		assertEquals(new FallingStrategy().hashCode(), strategy.hashCode());
		assertEquals(new GrowingStrategy().hashCode(), strategy1.hashCode());
		assertEquals(new NoChangingStrategy().hashCode(), strategy2.hashCode());
	}

	@Test
	public void testRealizeTradeIfPlayerDateIsChangedProperly() {
		Player player = new Player("Gracz");

		// mock Strategy
		Strategy mockStrategy = Mockito.mock(Strategy.class);

		List<String> nameOfBoughtActions = new ArrayList<String>();
		nameOfBoughtActions.add("A");
		nameOfBoughtActions.add("B");

		List<Long> numberOfBoughtActions = new ArrayList<Long>();
		numberOfBoughtActions.add(new Long(10));
		numberOfBoughtActions.add(new Long(10));

		List<Double> priceForOneBoughtActions = new ArrayList<Double>();
		priceForOneBoughtActions.add(new Double(2.0));
		priceForOneBoughtActions.add(new Double(3.0));

		List<String> nameOfSoldActions = new ArrayList<String>();
		nameOfSoldActions.add("C");
		nameOfSoldActions.add("D");

		List<Long> numberOfSoldtActions = new ArrayList<Long>();
		numberOfSoldtActions.add(new Long(10));
		numberOfSoldtActions.add(new Long(10));

		List<Double> priceForOneSoldActions = new ArrayList<Double>();
		priceForOneSoldActions.add(new Double(4.0));
		priceForOneSoldActions.add(new Double(5.0));

		ToBuyAndSellWithMarketTransport transportClass = new ToBuyAndSellWithMarketTransport(nameOfBoughtActions,
				numberOfBoughtActions, priceForOneBoughtActions, priceForOneSoldActions, nameOfSoldActions,
				numberOfSoldtActions);

		DataToStartegyTransport dataToStrategy = new DataToStartegyTransport(null, null, null);
		player.setDataToStrategy(dataToStrategy);
		player.setStrategy(mockStrategy);
		Mockito.doReturn(transportClass).when(mockStrategy).checkMovesInStrategy(dataToStrategy);

		// mock MarketOffice
		MarketOffice mockMarketOffice = Mockito.mock(MarketOffice.class);
		Mockito.doNothing().when(mockMarketOffice).buyAndSell(transportClass);

		player.realizeTrade();
		PlayerData playerData = player.getPlayerData();

		assertEquals(new Double(10040.0), playerData.getPlayerAccountState());

	}

}
