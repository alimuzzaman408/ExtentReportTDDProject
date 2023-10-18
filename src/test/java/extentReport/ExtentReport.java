package extentReport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Objects;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	private ExtentReport() {
	}

	public static ExtentReports extent;
	public static ExtentTest test;
	public static WebDriver driver;

	public static void intReport() throws IOException {
		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
			spark.loadXMLConfig(new File("extent-config.xml"));
			extent.attachReporter(spark);
		}
	}

	public static void flush() throws IOException {
		if (Objects.nonNull(extent)) {
			extent.flush();
			Desktop.getDesktop().browse(new File("index.html").toURI());
		}
	}

	public static void createTest(String testcasename) {
		ExtentManager.setExtentTest(extent.createTest(testcasename));
	}

}
