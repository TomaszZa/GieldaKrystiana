package com.capgemini.MarketPlay.Strategies;

import java.util.List;

public class ToBuyAndSellWithMarket {
	private List<String> nameOfBoughtActions;
	private List<Long> numberOfBoughtActions;
	private List<Double> priceForOneBoughtActions;
	private List<Double> priceForOneSoldActions;
	private List<String> nameOfSoldActions;
	private List<Long> numberOfSoldtActions;

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

	public List<String> getNameOfSoldActions() {
		return nameOfSoldActions;
	}

	public void setNameOfSoldActions(List<String> nameOfSoldActions) {
		this.nameOfSoldActions = nameOfSoldActions;
	}

	public List<Long> getNumberOfSoldtActions() {
		return numberOfSoldtActions;
	}

	public void setNumberOfSoldtActions(List<Long> numberOfSoldtActions) {
		this.numberOfSoldtActions = numberOfSoldtActions;
	}

	public List<Double> getPriceForOneSoldActions() {
		return priceForOneSoldActions;
	}

	public void setPriceForOneSoldActions(List<Double> priceForOneSoldActions) {
		this.priceForOneSoldActions = priceForOneSoldActions;
	}

}