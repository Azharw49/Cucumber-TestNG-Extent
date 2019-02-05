package runner;

import java.io.File;
import java.io.IOException;
import com.cucumber.listener.Reporter;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import cucumber.api.CucumberOptions;
import listener.ExtentProperties;
import wrappers.Generic;

@CucumberOptions(
		strict = true,
		monochrome = true, 
		features = "./features",
		glue = "stepDefinition",
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/report.html" }
		,dryRun=false
		
		,tags={"@Regression,@JunitScenario,@TestngScenario"}
		)

public class TestNGRunner1 extends Generic {

	@BeforeSuite(alwaysRun = true)
	public void setUp() throws Exception {
		deleteFilesInaDirectory(System.getProperty("user.dir") +"\\screenshots\\");
		startReport();
		
	}
	
	
	@BeforeClass()
	@Parameters("url")
	public void beforeClass(String url) throws Exception
	{
		loginToApp(url);
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass()
	{
		driver.quit();
	}



	@AfterSuite(alwaysRun = true)
	public void quit() throws IOException, InterruptedException {
		
		Reporter.loadXMLConfig(new File("./resources/extent-config.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", "Mac OSX");
		
	}
}
