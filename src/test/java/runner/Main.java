package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"classpath:features"}, glue = {"stepsDefinitions"},
                monochrome = true, dryRun = false,
                plugin = {"pretty", "html:target/cucumber"})
public class Main extends AbstractTestNGCucumberTests {

}
