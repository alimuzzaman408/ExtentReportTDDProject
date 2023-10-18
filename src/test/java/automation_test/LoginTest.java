package automation_test;

import org.testng.annotations.Test;
import PageObject.LoginPage;
import Utilites.ReadConfigFiles;
import basepackage.BaseClass;
import extentReport.ExtentReport;

public class LoginTest  extends BaseClass{
	
	@Test(priority=1)
	
	public void validloginTest() throws InterruptedException {
		new LoginPage(driver)
		.setUserName(ReadConfigFiles.getPropertyValues("username"))
		.setPassword(ReadConfigFiles.getPropertyValues("password"))
		.clickLogin()
	    .verifyPageTitle("Dashboard / nopCommerce administration")
	    .clickLogout();
	
	}
	
	@Test(priority=2)
	public void invalidloginTest() throws InterruptedException {
		new LoginPage(driver)
		.setUserName(ReadConfigFiles.getPropertyValues("username"))
		.setPassword(ReadConfigFiles.getPropertyValues("invalidpassword"))
		.clickLogin()
	    .invalidLogin();
	
	}


}
