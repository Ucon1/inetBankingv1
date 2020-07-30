package com.inetBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException 
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username entered");
		lp.setPassword(password);
		logger.info("Passwowd entered");
		lp.clickSubmit();
		
		//Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		Thread.sleep(3000);
		addcust.clickAddNewCustomer();
		logger.info("Entering customer details...");
		Thread.sleep(3000);
		addcust.custName("Charles Ukpai");
		addcust.custgender("male");
		addcust.custdob("03/","08/","1997");
		Thread.sleep(3000);
		addcust.custaddress("United Kingdom");
		addcust.custcity("Newcastle Upon Tyne");
		addcust.custstate("Northumberland");
		addcust.custpinno(500074);
		addcust.custtelephoneno("07387157322");
		
		String email = randomstring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcedf");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("Validation started....");
		
		boolean res = driver.getPageSource().contains("Customer Registered Successfully");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("Test case passed....");
		}
		else
		{
			logger.info("Test case failed.....");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	
	}
	
}
