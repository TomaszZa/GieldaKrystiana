package com.capgemini.MarketPlay.Main;

public class DateController {
	private static DateController instance = new DateController();
	private String actualDate = "02-01-2013";

	// singleton generujacy date
	private DateController() {
	}

	public void waitForNewDay() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// generacja nowej daty
	}

	public static DateController getInstance() {
		return instance;
	}

	public String getActualDate() {
		return actualDate;
	}

}
