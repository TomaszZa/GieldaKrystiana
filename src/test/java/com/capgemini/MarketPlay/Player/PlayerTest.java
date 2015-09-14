package com.capgemini.MarketPlay.Player;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.capgemini.MarketPlay.Market.DataToStartegyTransport;
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

}
