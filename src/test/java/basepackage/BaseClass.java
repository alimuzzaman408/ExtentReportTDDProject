package basepackage;

import command_providers.ActOn;
import extentReport.ExtentLogger;
import extentReport.ExtentManager;
import extentReport.ExtentReport;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.codec.AsciiHeadersEncoder.NewlineType;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import Utilites.ReadConfigFiles;

public class BaseClass {
	public static WebDriver driver;

	Logger LOGGER = LogManager.getLogger(this.getClass().getName());
	String testCaseName = String.format("--------Test: %s------------", this.getClass().getName());
	String endTestCase = String.format("--------Test End: %s------------", this.getClass().getName());

	@BeforeClass
	public void addThread() {
		ThreadContext.put("threadName", this.getClass().getName());
	}


	@BeforeMethod
	@Parameters("Browser")
	public void openBrowser(String browser,Method m) {
		ExtentReport.createTest(m.getName());
		String url = ReadConfigFiles.getPropertyValues("url");
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		LOGGER.info(testCaseName);
		LOGGER.debug("Open the URL: " + url);
		ExtentLogger.pass("URL is opened");
		ActOn.browser(driver).openBrowser(url);
	}

	@AfterMethod
	public void closeBrowser() {
		ActOn.browser(driver).closeBrowser();
		LOGGER.info(endTestCase);
		ExtentLogger.pass(endTestCase);
	}
}
