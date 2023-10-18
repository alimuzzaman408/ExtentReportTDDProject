//package extentReport;
//
//import java.awt.Desktop;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.Base64;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.commons.compress.utils.IOUtils;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.markuputils.Markup;
//import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//import com.aventstack.extentreports.reporter.configuration.util.IOUtil;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import io.github.bonigarcia.wdm.managers.VoidDriverManager;
//import net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName;
//
//public class ExtentReportClass {
//	public ExtentReports extent;
//	public WebDriver driver;
//
//	@BeforeSuite
//	public void setUp() throws IOException {
//		extent = new ExtentReports();
//		ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
//		spark.loadXMLConfig(new File("extent-config.xml"));
//		extent.attachReporter(spark);
//	}
//
//	@AfterSuite
//	public void teardown() throws IOException {
//		extent.flush();
//		Desktop.getDesktop().browse(new File("index.html").toURI());
//	}
//
//	@Test
//	public void attachScreenshot() throws IOException, InterruptedException {
//		ExtentTest test = extent.createTest("attachScreenshot");
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		test.pass("Browser is started");
//		driver.get("https://www.google.com/");
//		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Bangladesh", Keys.ENTER);
//		Thread.sleep(2000);
//		test.pass("Value is entered", MediaEntityBuilder.createScreenCaptureFromBase64String(Base64()).build());
//		driver.close();
//	}
//
//	public String getscreenshot() throws IOException {
//		// File
//		// sourceFile=driver.findElement(By.xpath("//textarea[@id='APjFqb']")).getScreenshotAs(OutputType.FILE);
//		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		String path = System.getProperty("user.dir") + "/screenshot/img.png";
//		FileUtils.copyFile(sourceFile, new File(path));
//		return path;
//	}
//
//	public String getscreenshotBase64() throws IOException {
//		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		String path = System.getProperty("user.dir") + "/screenshot/img.png";
//		FileUtils.copyFile(sourceFile, new File(path));
//		byte[] imgbyes = IOUtils.toByteArray(new FileInputStream(path));
//		return Base64.getEncoder().encodeToString(imgbyes);
//	}
//
//	public String Base64() {
//		// Recommande way to create screenshot
//		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
//	}
//
//	// public static void main(String[] args) throws ClassNotFoundException,
//	// IOException {
//	// ExtentReports extent = new ExtentReports();
//	// ExtentSparkReporter spark = new ExtentSparkReporter("index.html");
//	// extent.attachReporter(spark);
//	// spark.loadXMLConfig("extent-config.xml");
//	//// spark.config().setTheme(Theme.STANDARD);
//	//// spark.config().setDocumentTitle("Autommation Report");
//	//// spark.config().setReportName("Smoke Testing");
//	//
//	// ExtentTest test = extent.createTest("Login
//	// Test").assignAuthor("Ali").assignDevice("chrome").assignCategory("Regression");
//	// test.pass("Test is started");
//	// test.fail("Test is failed");
//	// test.skip("Test is skipped");
//	// //Arrays.asList(new String[]
//	// {"java","selenium","python"}).forEach(test::pass);
//	// //test.pass(MarkupHelper.createUnorderedList(Arrays.asList(new String[]
//	// {"java","selenium","python"})));
//	// Map<String, String> map=new HashMap<String,String>();
//	// map.put("Name", "Ali");
//	// map.put("gender", "Male");
//	// //map.forEach((k,v)->test.pass(k+" "+v));
//	// //test.pass(MarkupHelper.createUnorderedList(map).getMarkup());
//	//
//	//
//	//
//	// extent.flush();
//	// Desktop.getDesktop().browse(new File("index.html").toURI());
//	// }
//
//}
