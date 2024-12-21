package stepDefinations;

import java.io.IOException;

import io.cucumber.java.*;
import utility.ExtentReportUtil;

public class Hooks {

    @BeforeAll
    public static void beforeAll() {
        // Initialize the Extent Report only once
        ExtentReportUtil.initReport();
    }

    @AfterAll
    public static void afterAll() {
        // Flush the report after all scenarios have executed
        ExtentReportUtil.flushReport();
    }

    @Before("@DeletePlace")
    public void beforeDeletePlaceScenario() throws IOException {
        // Ensure the place_id is available before executing scenarios with @DeletePlace
        StepDefination stepDefinition = new StepDefination();
        if (StepDefination.place_id == null) {
            // Call the necessary methods to set the place_id
            stepDefinition.add_Place_Payload_with("Saurabh", "Espanol", "Barcelona, Spain");
            stepDefinition.user_calls_with_http_request("AddPlaceAPI", "POST");
            stepDefinition.verify_place_Id_created_maps_to_using("Saurabh", "getPlaceAPI");
        }
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        // Create a new test in Extent Report for every scenario
        ExtentReportUtil.createTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        // Log the scenario's result in the report
        if (scenario.isFailed()) {
            ExtentReportUtil.getTest().fail("Scenario failed: " + scenario.getName());
        } else {
            ExtentReportUtil.getTest().pass("Scenario passed: " + scenario.getName());
        }

        // Optionally log additional information
        ExtentReportUtil.getTest().info("Scenario execution completed.");
    }
}
