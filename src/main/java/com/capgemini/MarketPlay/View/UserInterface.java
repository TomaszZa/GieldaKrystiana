package com.capgemini.MarketPlay.View;

import java.util.Scanner;

import com.capgemini.MarketPlay.Player.Player;

public class UserInterface {
	private ChoosenStrategy strategy;
	private Player player;
	private Scanner input;

	public UserInterface(Player player) {
		this.player = player;
		this.input = new Scanner(System.in);
	}

	public void chooseStrategy() {
		String choose = "nothing";

		System.out.print("Choose your play strategy, ");
		System.out.print("Choose: GrowingStrategy,FallingStrategy,NoChangingStrategy: ");

		while (choose != "GrowingStrategy" && choose != "FallingStrategy" && choose != "NoChangingStrategy"
				&& input.hasNextLine()) {
			choose = input.nextLine();
		}

		switch (choose) {
		case "GrowingStrategy":
			strategy = ChoosenStrategy.GROWING_STRATEGY;
			break;
		case "FallingStrategy":
			strategy = ChoosenStrategy.FALLING_STRATEGY;
			break;
		case "NoChangingStrategy":
			strategy = ChoosenStrategy.NO_CHANGING_STARTEGY;
			break;
		}

		player.choosenStrategy(strategy);
	}

	public void showPlayerActions() {
		System.out.println("Player");
		// show everything from player model
	}

	public ChoosenStrategy getStrategy() {
		return strategy;
	}

	public void setStrategy(ChoosenStrategy strategy) {
		this.strategy = strategy;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Scanner getInput() {
		return input;
	}

	public void setInput(Scanner input) {
		this.input = input;
	}
}
