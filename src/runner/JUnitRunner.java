package runner;

import cucumber.api.CucumberOptions;

@CucumberOptions(
		strict = true,
		monochrome = true, 
		features = "./features/TrelloLogin.feature",
		glue = "stepDefinition",
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/report.html" }
		//,tags={"@Regression,@JunitScenario,@TestngScenario"}
		,dryRun=true
		)
public class JUnitRunner {

	
}
