package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
( 		
		features="classpath:features/gmo_simple.feature", // pick from src/test/resources
		glue="gmoStepDefs", //pick from src/test/java
		plugin = {"pretty",  // produce verbose report				
				"html:target/cucumber-reports/report.html", //generate HTML here
				"json:target/cucumber-reports/Cucumber.json", //to be post processed by user/other tools
				"junit:target/cucumber-reports/CucumberJunit.xml"}, //can be used to generate visual reports by user/other tools				
		monochrome=true,  //readable output in console, default false
		dryRun=false
		)
public class JUnitRunnerTest {
	
}
