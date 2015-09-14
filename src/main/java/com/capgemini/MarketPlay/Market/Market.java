package com.capgemini.MarketPlay.Market;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.capgemini.MarketPlay.Main.DateController;
import com.capgemini.MarketPlay.Strategies.ToBuyAndSellWithMarketTransport;

public class Market {
	private ReadFromFile file = new ReadFromFile();
	private HashSet<Company> companys = new HashSet<Company>();
	private DateController dateController; // podaje date dla gieldy

	public Market() {
	}

	public void startNewDayOnMarket() {
		int i = 0;
		String todayDate = dateController.getActualDate();

		for (String date : file.getDate()) {
			i++;
			if (todayDate.equals(date))
				createOrUbdateCompany(file.getCompanyName().get(i - 1), file.getPrice().get(i - 1),
						file.getDate().get(i - 1));
		}
	}

	private void createOrUbdateCompany(String name, Double todayPrice, String date) {
		Company tempCompany = new Company(name, todayPrice, date);

		if (!(companys.contains(tempCompany)))
			companys.add(tempCompany);

		if (companys.contains(tempCompany))
			for (Company company : companys) {
				if (company.equals(tempCompany)) {
					company.addNewPrice(todayPrice, date);
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
					boughtPrices.add(boughtActionCount - 1, company.getTodayPrice());
			}
			for (String actionOfCompanyName : actions.getNameOfSoldActions()) {
				soldActionCount++;
				if (company.getName() == actionOfCompanyName)
					soldPrices.add(soldActionCount - 1, company.getTodayPrice());
			}
		}
	}

	public ReadFromFile getFile() {
		return file;
	}

	public void setFile(ReadFromFile file) {
		this.file = file;
	}

	public HashSet<Company> getCompanys() {
		return companys;
	}

	public void setCompanys(HashSet<Company> companys) {
		this.companys = companys;
	}

	public DateController getDateController() {
		return dateController;
	}

	public void setDateController(DateController dateController) {
		this.dateController = dateController;
	}
}
