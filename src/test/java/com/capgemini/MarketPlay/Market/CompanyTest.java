package com.capgemini.MarketPlay.Market;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CompanyTest {
	@Test
	public void testIfCompanyContructorCauseAddingProperValueAndCountGrowPoint() {
		Company company = new Company("AGH", new Double(20.0), "1990-6-21");

		assertEquals("AGH", company.getName());
		assertEquals(new Double(20.0), company.getTodayPrice());
		assertEquals(new Double(20.0), company.getGrowPoint());
		assertTrue(company.getPrices().containsKey("1990-6-21"));
	}

	@Test
	public void testIfAddNewPriceAddProperChanges() {
		Company company = new Company("AGH", new Double(20.0), "1990-6-21");
		company.addNewPrice(new Double(30.0), "1990-6-30");

		assertEquals(new Double(30.0), company.getTodayPrice());
		assertTrue(company.getPrices().containsKey("1990-6-30"));
		assertEquals(2, company.getPrices().size());
	}

}
