package com.capgemini.MarketPlay.Market;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.capgemini.MarketPlay.Strategies.ToBuyAndSellWithMarket;

public class Market {
	private ReadFromFile file = new ReadFromFile();
	private HashSet<Company> companys;

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

	public DataToStartegy getRecentDataToStrategy() {
		List<String> nameActions = new ArrayList<String>();
		List<Double> todayPriceForActions = new ArrayList<Double>();
		List<Double> growPoint = new ArrayList<Double>();

		for (Company company : companys) {
			nameActions.add(company.getName());
			todayPriceForActions.add(company.getTodayPrice());
			growPoint.add(company.getGrowPoint());
		}

		return new DataToStartegy(nameActions, todayPriceForActions, growPoint);
	}

	public void buyAndSell(ToBuyAndSellWithMarket actions) {
		int i;
		int j;
		List<Double> boughtPrices = actions.getPriceForOneBoughtAction();
		List<Double> soldPrices = actions.getPriceForOneBoughtAction();

		for (Company company : companys) {
			i = 0;
			j = 0;
			for (String actionName : actions.getNameOfBoughtActions()) {
				i++;
				if (company.getName() == actionName)
					boughtPrices.set(i - 1, company.getTodayPrice());
			}
			for (String actionName : actions.getNameOfSoldActions()) {
				j++;
				if (company.getName() == actionName)
					soldPrices.set(i - 1, company.getTodayPrice());
			}
		}
	}

}
