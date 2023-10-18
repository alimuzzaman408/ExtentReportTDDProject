package automation_test;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import PageObject.CustomerPage;
import PageObject.LoginPage;
import Utilites.ReadConfigFiles;
import basepackage.BaseClass;
import extentReport.ExtentReport;

public class CustomerPageTest extends BaseClass {

	@Test
	public void addingNewCustomer() throws InterruptedException {
		//ExtentReport.createTest("Adding New Customer");
		new LoginPage(driver)
		.setUserName(ReadConfigFiles.getPropertyValues("username"))
		.setPassword(ReadConfigFiles.getPropertyValues("password"))
		.clickLogin()
		.verifyPageTitle("Dashboard / nopCommerce administration");

		new CustomerPage(driver)	
		.clickOnCustomersMenu()
		.clickOnCustomersMenuItem()
		.clickOnAddnew()
		.setEmail()
		.setPassword("asjj234")
		.setFirstName("Mohan")
		.setLastName("Kazi")
		.setGender("Male")
		.setDob("12/5/1975")
		.setCompanyName("Sage")
		.setCustomerRoles("Guests")
		.setAdminComment("this is shapan")
		.clickOnSave();
	}

}
