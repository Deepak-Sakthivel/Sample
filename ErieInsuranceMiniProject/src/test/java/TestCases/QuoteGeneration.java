package TestCases;

import org.testng.annotations.Test;

import PageObjectModel.GetQuotePage;
import TestComponents.BaseTest;

public class QuoteGeneration extends BaseTest{
	
	@Test
	public void testCase1() throws InterruptedException
	{
		GetQuotePage g = l.selectInsuranceType("AUTO INSURANCE");
		l.quoteBtnVisibility();
		Thread.sleep(3000);
		g.getQuote();
	}

}
