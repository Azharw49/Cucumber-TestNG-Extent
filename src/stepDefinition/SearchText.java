package stepDefinition;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;

import cucumber.api.java.en.When;
import runner.CucumberRunner;
import runner.TestNGRunner1;

public class SearchText extends TestNGRunner1 {
   // String screenshot = "snap"+new Date();
	@When("^I type \"(.*?)\"$")
	public void searchText(String text) throws Throwable {
		WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"lst-ib\"]"));
		explicitWait(searchBox);
		searchBox.sendKeys(text);
		
		
		
	}

}
