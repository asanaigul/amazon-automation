package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Runner class to execute the scripts.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"html:target/cucumber", "json:target/report.json" },
		features = "src/test/resources/com/fm/lppub/features/login",
		glue = "com/fm/login/step_defs",
		tags = "@2",
		dryRun = false
		)

public class CukesRunner {
    
  
}
