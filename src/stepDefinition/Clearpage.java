package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;
import runner.CucumberRunner;
import runner.TestNGRunner1;

public class Clearpage extends TestNGRunner1 {
	

	@Then("^I clear search textbox$")
	public void Clear() throws Throwable {
		WebElement clearSearchBox = driver.findElement(By.cssSelector("input[name='q']"));
		explicitWait(clearSearchBox);
		clearSearchBox.clear();

	}

}
