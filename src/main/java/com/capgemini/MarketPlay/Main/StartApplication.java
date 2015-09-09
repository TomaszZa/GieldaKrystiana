package com.capgemini.MarketPlay.Main;

import com.capgemini.MarketPlay.Market.Market;
import com.capgemini.MarketPlay.Player.Player;
import com.capgemini.MarketPlay.View.UserInterface;

public class StartApplication {
	public static void main(String[] args) {
		// ma co okreslony czas wywolywac akcje
		String previusDate = "Date";
		Player player = new Player("Krystian");
		UserInterface view = new UserInterface(player);
		Market market = new Market();
		DateController date = DateController.getInstance();

		view.chooseStrategy();
		for (;;) {
			date.waitForNewDay();
			if (!(date.getActualDate().equals(previusDate))) {
				previusDate = date.getActualDate();

				market.startNewDayOnMarket(date.getActualDate());
				player.takeNeededDate();
				player.realizeTrade();
				view.showPlayerActions();
			}
		}

	}

}
