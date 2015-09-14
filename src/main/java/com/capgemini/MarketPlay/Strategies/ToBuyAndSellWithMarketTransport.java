package com.capgemini.MarketPlay.Strategies;

import java.util.ArrayList;
import java.util.List;

public class ToBuyAndSellWithMarketTransport {
	private List<String> nameOfBoughtActions = new ArrayList<String>();
	private List<Long> numberOfBoughtActions = new ArrayList<Long>();
	private List<Double> priceForOneBoughtActions = new ArrayList<Double>();
	private List<Double> priceForOneSoldActions = new ArrayList<Double>();
	private List<String> nameOfSoldActions = new ArrayList<String>();
	private List<Long> numberOfSoldtActions = new ArrayList<Long>();

	public ToBuyAndSellWithMarketTransport() {
	}

	public ToBuyAndSellWithMarketTransport(List<String> nameOfBoughtActions, List<Long> numberOfBoughtActions,
			List<Double> priceForOneBoughtActions, List<Double> priceForOneSoldActions, List<String> nameOfSoldActions,
			List<Long> numberOfSoldtActions) {
		this.nameOfBoughtActions = nameOfBoughtActions;
		this.numberOfBoughtActions = numberOfBoughtActions;
		this.priceForOneBoughtActions = priceForOneBoughtActions;
		this.priceForOneSoldActions = priceForOneSoldActions;
		this.nameOfSoldActions = nameOfSoldActions;
		this.numberOfSoldtActions = numberOfSoldtActions;
	}

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