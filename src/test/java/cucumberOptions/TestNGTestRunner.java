package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features= "C:/Users/New/IdeaProjects/CucumberFramework/src/test/java/features",glue="stepDefinitions",monochrome = true,dryRun = true)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
}
