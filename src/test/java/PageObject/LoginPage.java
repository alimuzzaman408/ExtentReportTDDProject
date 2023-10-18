package PageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.MediaEntityBuilder;

import command_providers.ActOn;
import extentReport.ExtentLogger;
import extentReport.ExtentManager;
import extentReport.ExtentReport;

public class LoginPage {
	public static WebDriver driver;

	private static final Logger LOGGER = LogManager.getLogger(LoginPage.class);

	private static final By textmail = By.xpath("//*[@id='Email']");
	private static final By error = By.xpath("//li[normalize-space()='The credentials provided are incorrect']");
	private static final By txtPassword = By.xpath("//*[@id='Password']");
	private static final By btnLogin = By.xpath("//button[normalize-space()='Log in']");
	private static final By lnkLogout = By.xpath("//a[normalize-space()='Logout']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage setUserName(String uname) {
		ActOn.wait(driver, textmail);
		ActOn.element(driver, textmail).setValue(uname);
		LOGGER.info("usenname entered");
		ExtentLogger.pass("Username is entered");
		return this;
	}

	public LoginPage setPassword(String pwd) {
		ActOn.wait(driver, txtPassword);
		ActOn.element(driver, txtPassword).setValue(pwd);
		ExtentLogger.pass("Password is entered");
		return this;
	}

	public LoginPage clickLogin() throws InterruptedException {
		ActOn.wait(driver, btnLogin);
		ActOn.element(driver, btnLogin).click();
		ExtentLogger.pass("Login Btn is clicked");
		return this;
	}

	public LoginPage verifyPageTitle(String title) {
		ActOn.browser(driver).validateTitle(title);
		LOGGER.info("************* Login Passed *****************");
		// ExtentReport.test.pass("Home page title is validated");
		ExtentLogger.pass("Home page title is validated");
		return this;
	}

	public LoginPage clickLogout() {
		ActOn.wait(driver, lnkLogout);
		ActOn.element(driver, lnkLogout).click();
		ExtentLogger.pass("LogOut Btn is clicked");
		return this;
	}

	public LoginPage invalidLogin() {
		ActOn.wait(driver, error).waitForElementToBeVisible();
		String value = ActOn.element(driver, error).getTextValue();
		if (value.contains("The credentials provided are incorrect")) {
			LOGGER.info("Test is passed");
			ExtentLogger.pass("Test is passed");
		} else {
			LOGGER.info("Test is failed");
			ExtentLogger.pass("Test is failed, Text value does not match with actual value");
		}
		return this;
	}
}

// @FindBy(xpath="//*[@id='Email']")
// private static WebElement textmail;
//
// @FindBy(how=How.XPATH,using="//li[normalize-space()='The credentials provided
// are incorrect']")
// private static WebElement error;
//
// @FindBy(how=How.XPATH,using="//*[@id='Password']")
// private static WebElement txtPassword;
//
// @FindBy(how=How.XPATH,using="//button[normalize-space()='Log in']")
// private static WebElement btnLogin;
//
// @FindBy(how=How.XPATH,using="//a[normalize-space()='Logout']")
// private static WebElement lnkLogout;
