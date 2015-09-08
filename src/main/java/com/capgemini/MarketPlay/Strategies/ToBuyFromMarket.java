package com.capgemini.MarketPlay.Strategies;

import java.util.List;

public class ToBuyFromMarket {
	private List<String> nameOfBoughtActions;
	private List<Long> numberOfBoughtActions;
	private List<Double> priceForOneBoughtActions;

	public List<String> getNameOfBoughtActions() {
		return nameOfBoughtActions;
	}

	public void setNameOfBoughtActions(List<String> nameOfBoughtActions) {
		this.nameOfBoughtActions = nameOfBoughtActions;
	}

	public List<Long> getNumberOfBoughtActions() {
		return numberOfBoughtActions;
	}

	public void setNumberOfBoughtActions(List<Long> numberOfBoughtActions) {
		this.numberOfBoughtActions = numberOfBoughtActions;
	}

	public List<Double> getPriceForOneBoughtAction() {
		return priceForOneBoughtActions;
	}

	public void setPriceForOneBoughtAction(List<Double> priceForOneBoughtActions) {
		this.priceForOneBoughtActions = priceForOneBoughtActions;
	}

}