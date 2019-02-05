package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;

import com.cucumber.listener.Reporter;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import gherkin.formatter.model.Result;
import listener.ExtentProperties;



public class Generic extends AbstractTestNGCucumberTests{
	public static WebDriver driver = null;
	public static Properties config = null;

	public String getUniqueFileName(){
		SimpleDateFormat ft = new SimpleDateFormat ("MMddyyHHmmss");
		return ft.format(new Date());
	}

	public void takeScreenshot() throws IOException

	{
		String screenshot = "snap"+getUniqueFileName();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") +"\\screenshots\\"+screenshot+".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		Reporter.addScreenCaptureFromPath(dest);	
	}
	
	public String stringStackTrace(Exception e)
	{
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		String exceptionAsString = sw.toString();
		return exceptionAsString;
	}


	public void LoadConfigProperty() throws IOException {
		config = new Properties();
		FileInputStream ip = new FileInputStream(new File("./config/config.properties"));
		config.load(ip);
	}

	public void openBrowser() throws Exception {
		LoadConfigProperty();
		if (config.getProperty("browserType").equals("Firefox")) {

			driver = new FirefoxDriver();
		} else if (config.getProperty("browserType").equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();

		}
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

	public void explicitWait(WebElement element) {
		WebDriverWait wait  = new WebDriverWait(driver, 3000);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void pageLoad(int time) {
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}

	public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
	}

	
	public void setEnv(String url) throws Exception {
		LoadConfigProperty();
		String baseUrl = config.getProperty(url);
		driver.get(baseUrl);
		driver.findElement(By.name("button")).click();
	}
	
	public void setEnv() throws Exception {
		LoadConfigProperty();
		String baseUrl = config.getProperty("siteRunner1");
		driver.get(baseUrl);
		driver.findElement(By.name("button")).click();
	}
	
	
	public void loginToApp(String url) throws Exception
	{
	openBrowser();
	maximizeWindow();
	implicitWait(10);
	deleteAllCookies();
	setEnv(url);
	}
	
	public void loginToApp( ) throws Exception
	{
	openBrowser();
	maximizeWindow();
	implicitWait(10);
	deleteAllCookies();
	setEnv();
	}
	
	

	public static String currentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String cal1 = dateFormat.format(cal.getTime());
		return cal1;
	}
	
	
	public ExtentProperties startReport()
	{
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		extentProperties.setReportPath("./output/myreport.html");
		return extentProperties;
	}
	
	public void deleteFilesInaDirectory(String folder) throws IOException
	{
		FileUtils.cleanDirectory(new File(folder));
	}
	
	public void enterTextById( String id, String valueToEnter) throws IOException{
		try {
			driver.findElement(By.id(id)).clear();
			driver.findElement(By.id(id)).sendKeys(valueToEnter);
			
		} catch (NoSuchElementException e) {
			Reporter.addStepLog("Unable to locate an element with id="+id);
			takeScreenshot();
			Assert.fail();
		} catch (WebDriverException e) {
			Reporter.addStepLog(stringStackTrace(e));
			Assert.fail();	
		} catch (Exception e) {
			Reporter.addStepLog(stringStackTrace(e));
			Assert.fail();
			
		}
	}
	
	public void clickById( String id) throws IOException{
		try {
			driver.findElement(By.id(id)).click();
			
	} catch (NoSuchElementException e) {
		Reporter.addStepLog("Unable to locate an element with id="+id);
		Assert.fail();
		
	} catch (WebDriverException e) {
		Reporter.addStepLog(stringStackTrace(e));
		Assert.fail();	
	} catch (Exception e) {
		Reporter.addStepLog(stringStackTrace(e));
		Assert.fail();
		
	}
	     }


	

}
