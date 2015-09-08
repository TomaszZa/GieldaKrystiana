package com.capgemini.MarketPlay.Market;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.capgemini.MarketPlay.Strategies.ToBuyFromMarket;

public class Market {
	private ReadFromFile file = new ReadFromFile();
	private HashSet<Company> companys;

	public Market(String todayDate) {
		startNewDayOnMarket(todayDate);
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

	public void buy(ToBuyFromMarket actions) {
		int i;
		List<Double> prices = actions.getPriceForOneBoughtAction();

		for (Company company : companys) {
			i = 0;
			for (String actionName : actions.getNameOfBoughtActions()) {
				i++;
				if (company.getName() == actionName)
					prices.set(i - 1, company.getTodayPrice());
			}
		}
	}

}
