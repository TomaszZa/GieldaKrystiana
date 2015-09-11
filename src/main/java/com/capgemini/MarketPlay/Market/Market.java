package com.capgemini.MarketPlay.Market;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.capgemini.MarketPlay.Main.DateController;
import com.capgemini.MarketPlay.Strategies.ToBuyAndSellWithMarketTransport;

public class Market {
	private ReadFromFile file = new ReadFromFile();
	private HashSet<Company> companys;
	private DateController dateController; // podaje date dla gieldy

	public Market() {
	}

	public void startNewDayOnMarket(String todayDate) {
		int i = 0;
		for (String date : file.getDate()) {
			i++;
			if (todayDate.equals(date))
				createCompany(file.getCompanyName().get(i - 1), file.getPrice().get(i - 1), file.getDate().get(i - 1));
		}
	}

	private void createCompany(String name, Double todayPrice, String date) {
		Company tempCompany = new Company(name, todayPrice, date);
		for (Company company : companys) {
			if (company.equals(tempCompany)) {
				company.addNewPrice(todayPrice, date);
			}
			if (!(company.equals(tempCompany))) {
				companys.add(tempCompany);
			}
		}
	}

	public DataToStartegyTransport getRecentDataToStrategy() {
		List<String> nameActions = new ArrayList<String>();
		List<Double> todayPriceForActions = new ArrayList<Double>();
		List<Double> growPoint = new ArrayList<Double>();

		for (Company company : companys) {
			nameActions.add(company.getName());
			todayPriceForActions.add(company.getTodayPrice());
			growPoint.add(company.getGrowPoint());
		}

		return new DataToStartegyTransport(nameActions, todayPriceForActions, growPoint);
	}

	public void buyAndSell(ToBuyAndSellWithMarketTransport actions) {
		List<Double> boughtPrices = actions.getPriceForOneBoughtAction();
		List<Double> soldPrices = actions.getPriceForOneSoldActions();
		int boughtActionCount;
		int soldActionCount;

		for (Company company : companys) {
			boughtActionCount = 0;
			soldActionCount = 0;
			for (String actionOfCompanyName : actions.getNameOfBoughtActions()) {
				boughtActionCount++;
				if (company.getName() == actionOfCompanyName)
					boughtPrices.set(boughtActionCount - 1, company.getTodayPrice());
			}
			for (String actionOfCompanyName : actions.getNameOfSoldActions()) {
				soldActionCount++;
				if (company.getName() == actionOfCompanyName)
					soldPrices.set(boughtActionCount - 1, company.getTodayPrice());
			}
		}
	}

}
