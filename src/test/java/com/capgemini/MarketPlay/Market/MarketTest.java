package com.capgemini.MarketPlay.Market;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import com.capgemini.MarketPlay.Main.DateController;
import com.capgemini.MarketPlay.Strategies.ToBuyAndSellWithMarketTransport;

public class MarketTest {

	@Test
	public void testIfStartNewDayOnMarketAddCompanyAndThenChangeItsDataProperly() {
		Market market = new Market();
		// mocking ReadFromFile class
		ReadFromFile mockFile = Mockito.mock(ReadFromFile.class);

		List<String> companyNames = new ArrayList<String>();
		List<Double> prices = new ArrayList<Double>();
		List<String> dates = new ArrayList<String>();

		companyNames.add("KGH");
		prices.add(new Double(20.0));
		dates.add("1991-6-19");

		Mockito.doReturn(companyNames).when(mockFile).getCompanyName();
		Mockito.doReturn(prices).when(mockFile).getPrice();
		Mockito.doReturn(dates).when(mockFile).getDate();
		// mocking DateController
		DateController mockDateController = Mockito.mock(DateController.class);

		Mockito.doReturn("1991-6-19").when(mockDateController).getActualDate();
		// when
		market.setFile(mockFile);
		market.setDateController(mockDateController);
		market.startNewDayOnMarket();
		// then
		Company company = new Company("KGH", new Double(20.0), "1991-6-19");
		assertTrue(market.getCompanys().contains(company));
		// mocking ReadFromFile class with new price
		companyNames.add("KGH");
		prices.add(new Double(40.0));
		dates.add("1991-6-19");

		Mockito.doReturn(companyNames).when(mockFile).getCompanyName();
		Mockito.doReturn(prices).when(mockFile).getPrice();
		Mockito.doReturn(dates).when(mockFile).getDate();
		// then
		Company company1 = new Company("KGH", new Double(40.0), "1991-6-19");
		assertTrue(market.getCompanys().contains(company1));
		assertEquals(1, market.getCompanys().size());
	}

	@Test
	public void testGetRecentDataToStrategyIfCreateTransportClassProperly() {
		Market market = new Market();

		List<String> nameActions = new ArrayList<String>();
		List<Double> todayPriceForActions = new ArrayList<Double>();
		List<Double> growPoint = new ArrayList<Double>();

		nameActions.add("A");
		nameActions.add("B");
		todayPriceForActions.add(new Double(1.0));
		todayPriceForActions.add(new Double(2.0));
		growPoint.add(new Double(1.0));
		growPoint.add(new Double(2.0));

		DataToStartegyTransport dateToStrategy = new DataToStartegyTransport(nameActions, todayPriceForActions,
				growPoint);

		Company company1 = new Company("A", new Double(1.0), "1111-11-11");
		Company company2 = new Company("B", new Double(2.0), "1111-11-11");

		HashSet<Company> companys = new HashSet<Company>();
		companys.add(company1);
		companys.add(company2);

		market.setCompanys(companys);

		assertEquals(dateToStrategy.getNameActions().get(0), market.getRecentDataToStrategy().getNameActions().get(0));
		assertEquals(dateToStrategy.getTodayPriceForActions().get(0),
				market.getRecentDataToStrategy().getTodayPriceForActions().get(0));
		assertEquals(dateToStrategy.getGrowPoint().get(0), market.getRecentDataToStrategy().getGrowPoint().get(0));
	}

	@Test
	public void testBuyAndSellIfAddPricesProperly() {
		List<String> nameOfSoldActions = new ArrayList<String>();
		List<String> nameOfBoughtActions = new ArrayList<String>();

		Market market = new Market();

		nameOfSoldActions.add("A");
		nameOfBoughtActions.add("B");

		ToBuyAndSellWithMarketTransport transportClass = new ToBuyAndSellWithMarketTransport(nameOfBoughtActions,
				new ArrayList<Long>(), new ArrayList<Double>(), new ArrayList<Double>(), nameOfSoldActions,
				new ArrayList<Long>());

		Company company1 = new Company("A", new Double(20.0), "9999-9-99");
		Company company2 = new Company("B", new Double(10.0), "9999-9-99");

		HashSet<Company> companys = new HashSet<Company>();
		companys.add(company1);
		companys.add(company2);

		market.setCompanys(companys);
		market.buyAndSell(transportClass);

		assertEquals(new Double(20.0), transportClass.getPriceForOneSoldActions().get(0));
		assertEquals(new Double(10.0), transportClass.getPriceForOneBoughtAction().get(0));
	}

}
