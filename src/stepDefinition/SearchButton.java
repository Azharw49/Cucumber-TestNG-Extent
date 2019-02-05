package stepDefinition;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.cucumber.listener.Reporter;

import cucumber.api.java.en.Then;
import runner.CucumberRunner;
import runner.TestNGRunner1;

public class SearchButton extends TestNGRunner1 {

	@Then("^I click search button$")
	public void searchButton() throws Throwable {
		WebElement searchBox = driver.findElement(By.cssSelector("input[name='q']"));
		explicitWait(searchBox);
		searchBox.sendKeys(Keys.ENTER);
		takeScreenshot();

	}

}
