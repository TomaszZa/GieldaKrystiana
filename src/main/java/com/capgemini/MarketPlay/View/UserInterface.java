package com.capgemini.MarketPlay.View;

import java.io.IOException;

import com.capgemini.MarketPlay.Player.Player;

public class UserInterface {
	private ChoosenStrategy strategy;
	private Player player;

	public UserInterface(Player player) {
		this.player = player;
	}

	public void chooseStrategy() {
		Character choose = 'n';

		System.out.print("Choose your play strategy, ");
		System.out.print("a-growing strategy,b-falling strategy,c-no changing strategy: ");

		for (; choose != 'a' || choose != 'b' || choose != 'c';) {
			try {
				choose = (char) System.in.read();
			} catch (IOException e) {
				System.out.println("Problem with reading Sign");
			}
		}

		switch (choose) {
		case 'a':
			strategy = ChoosenStrategy.GROWING_STRATEGY;
			break;
		case 'b':
			strategy = ChoosenStrategy.FALLING_STRATEGY;
			break;
		case 'c':
			strategy = ChoosenStrategy.NO_CHANGING_STARTEGY;
			break;
		}

		player.choosenStrategy(strategy);
	}

	public void showPlayerActions() {
		System.out.println("Player");
		// show everything from player
	}

}
