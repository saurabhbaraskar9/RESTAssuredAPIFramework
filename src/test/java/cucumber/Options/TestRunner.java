package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        plugin = {"json:target/jsonReports/cucumber-report.json"},
        glue = {"stepDefinations"},
        tags = "@Regression or @DeleteSpecificPlace"
)
public class TestRunner {
    // No additional fields or methods are required for this runner class
}
