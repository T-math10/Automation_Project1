package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/features/"},
        glue = {"stepDefinitions"},
        tags = "@Test"
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
    public TestNGTestRunner() {

    }
}
