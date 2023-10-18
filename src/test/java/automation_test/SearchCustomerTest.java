package automation_test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import PageObject.CustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomer;
import Utilites.ReadConfigFiles;
import basepackage.BaseClass;
import extentReport.ExtentReport;

public class SearchCustomerTest extends BaseClass{	
	@Test
	public void searchByEmail() throws InterruptedException {
		//ExtentReport.createTest("searchByEmail");
		new LoginPage(driver)
		.setUserName(ReadConfigFiles.getPropertyValues("username"))
		.setPassword(ReadConfigFiles.getPropertyValues("password"))
		.clickLogin()
		.verifyPageTitle("Dashboard / nopCommerce administration")	;

		new CustomerPage(driver)	
		.clickOnCustomersMenu()
		.clickOnCustomersMenuItem();

		new SearchCustomer(driver)
		.setemail("victoria_victoria@nopCommerce.com")
		.clicksearch()
		.searchbyEmail("victoria_victoria@nopCommerce.com");
	}

	@Test
	public void searchByname() throws InterruptedException {
		//ExtentReport.createTest("searchByName");
		new LoginPage(driver)
		.setUserName(ReadConfigFiles.getPropertyValues("username"))
		.setPassword(ReadConfigFiles.getPropertyValues("password"))
		.clickLogin()
		.verifyPageTitle("Dashboard / nopCommerce administration");	
		
		new CustomerPage(driver)	
		.clickOnCustomersMenu()
		.clickOnCustomersMenuItem();
		
		new SearchCustomer(driver)
		.setfirstname("victoria")
		.setlastname("Terces")
		.clicksearch()
		.searchbyname("Victoria Terces");

	}


}