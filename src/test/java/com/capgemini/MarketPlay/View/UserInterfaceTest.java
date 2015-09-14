package com.capgemini.MarketPlay.View;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Test;

import com.capgemini.MarketPlay.Player.Player;

public class UserInterfaceTest {

	@Test
	public void testChooseStrategyIfChoosenGrowingStrategyFromConsolIsReadProperly() {
		Player player = new Player("Gracz");
		UserInterface view = new UserInterface(player);

		// Podmiana zrodla System.in z consol na zdefiniowane samemu
		String choosenStrategy = "GrowingStrategy\n";
		InputStream in = new ByteArrayInputStream(choosenStrategy.getBytes());
		System.setIn(in);
		Scanner inputtt = new Scanner(System.in);
		view.setInput(inputtt);

		view.chooseStrategy();
		assertEquals(ChoosenStrategy.GROWING_STRATEGY, view.getStrategy());

	}

	@Test
	public void testChooseStrategyIfChoosenFallingStrategyFromConsolIsReadProperly() {
		Player player = new Player("Gracz");
		UserInterface view = new UserInterface(player);

		// Podmiana zrodla System.in z consol na zdefiniowane samemu
		String choosenStrategy = "GrowingStrategy\n";
		InputStream in = new ByteArrayInputStream(choosenStrategy.getBytes());
		System.setIn(in);
		Scanner inputtt = new Scanner(System.in);
		view.setInput(inputtt);

		view.chooseStrategy();
		assertEquals(ChoosenStrategy.GROWING_STRATEGY, view.getStrategy());

	}

	@Test
	public void testChooseStrategyIfChoosenNoChangeStrategyFromConsolIsReadProperly() {
		Player player = new Player("Gracz");
		UserInterface view = new UserInterface(player);

		// Podmiana zrodla System.in z consol na zdefiniowane samemu
		String choosenStrategy = "GrowingStrategy\n";
		InputStream in = new ByteArrayInputStream(choosenStrategy.getBytes());
		System.setIn(in);
		Scanner inputtt = new Scanner(System.in);
		view.setInput(inputtt);

		view.chooseStrategy();
		assertEquals(ChoosenStrategy.GROWING_STRATEGY, view.getStrategy());

	}

}
