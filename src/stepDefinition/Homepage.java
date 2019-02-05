package stepDefinition;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import runner.CucumberRunner;
import runner.TestNGRunner1;

public class Homepage extends TestNGRunner1 {

	@Given("^I am on \"(.*?)\" search page$")
	public void googlePage(String text) throws Throwable {

		String title = driver.getTitle();
			if(text == "google") {
				//Assert.assertEquals(title, "Google");
				System.out.println("hi");
			} else if(text == "cucumber") {
				Assert.assertEquals(title, "cucumber - Google Search");
			} else if(text == "junit") {
				Assert.assertEquals(title, "junit - Google Search");
			}   		
	}

}
