package com.capgemini.MarketPlay.Main;

import com.capgemini.MarketPlay.Player.Player;
import com.capgemini.MarketPlay.View.UserInterface;

public class StartApplication {
	public static void main(String[] args) {
		// ma co okreslony czas wywolywac akcje
		String startDate = "02-01-2013";
		Player player = new Player("Krystian", "date tu wstawic!!!!!!!!!");
		UserInterface view = new UserInterface(player);
		view.chooseSrategy();
		player.choosenStartegy();
		player.takeNeededDate();
		player.realizeTrade();
		player.showPlayerActions();
	}

}
