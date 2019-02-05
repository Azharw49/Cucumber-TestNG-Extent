package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import runner.TestNGRunner1;
import runner.TestNGRunner2;

public class Trello extends TestNGRunner2 {
	
	@Given("^I am on Tello Login Page$")
	public void i_am_on_Tello_Login_Page() throws Throwable {
		
	    
	}

	

	@When("^I clicked on Login button$")
	public void i_clicked_on_Login_button() throws Throwable {
		
		clickById("login");
	}
	
	@When("^I entered my \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_entered_my_and(String arg1, String arg2) throws Throwable {
		enterTextById("user",arg1);
		enterTextById("password",arg2);
	}

	@Then("^I got navigated to Trello Home Page$")
	public void i_got_navigated_to_Trello_Home_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(5000);
		takeScreenshot();
	    
	}

}
