package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.*;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;
import utility.ExtentReportUtil;

public class StepDefination extends Utils {
    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    TestDataBuild data = new TestDataBuild();
    static String place_id;
    private static final Logger log = Logger.getLogger(StepDefination.class.getName());


    @Given("Add Place Payload with {string}  {string} {string}")
    public void add_Place_Payload_with(String name, String language, String address) throws IOException {

        ExtentReportUtil.getTest().log(Status.PASS, "API test started successfully");


        res = given().spec(requestSpecification()).log().all()
                .body(data.addPlacePayLoad(name, language, address));
    }

    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String method) {
        APIResources resourceAPI = APIResources.valueOf(resource);
        System.out.println(resourceAPI.getResource());

        resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

        if (method.equalsIgnoreCase("POST"))
            response = res.when().post(resourceAPI.getResource());
        else if (method.equalsIgnoreCase("GET"))
            response = res.when().get(resourceAPI.getResource());
        else if (method.equalsIgnoreCase("PUT"))
            response = res.when().put(resourceAPI.getResource());

    }

    @Then("the API call got success with status code {int}")
    public void the_API_call_got_success_with_status_code(Integer int1) {
        System.out.print("Status Code is-  " + response.getStatusCode());
        assertEquals(response.getStatusCode(), 200);


    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String Expectedvalue) {
        log.info("Status is-  " + response.getStatusLine());
        log.info("Response is   " + response.asString());
        assertEquals(getJsonPath(response, keyValue), Expectedvalue);
    }

    @Then("verify place_Id created maps to {string} using {string}")
    public void verify_place_Id_created_maps_to_using(String expectedName, String resource) throws IOException {

        place_id = getJsonPath(response, "place_id");
        res = given().spec(requestSpecification()).queryParam("place_id", place_id);
        user_calls_with_http_request(resource, "GET");
        String actualName = getJsonPath(response, "name");
        assertEquals(actualName, expectedName);
        ExtentReportUtil.getTest().log(Status.PASS, "API response checked successfully");


    }


    @Given("DeletePlace Payload")
    public void deleteplace_Payload() throws IOException {
        log.info("Place with place ID to be deleted-  " + place_id);
        ExtentReportUtil.getTest().log(Status.PASS, "Deleting place...");
        res = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
        log.info(res.toString());
        ExtentReportUtil.getTest().log(Status.PASS, "Place deleted successfully");

    }


    @Given("GetPlace Payload with {string}")
    public void getplacePayloadWith(String place_ID) throws IOException {
        ExtentReportUtil.getTest().log(Status.PASS, " Getting place...");
        log.info("Place with place ID to be fetched-  " + place_ID);
        res = given().spec(requestSpecification()).queryParam("key", "qaclick123")
                .queryParam("place_id", place_ID);
        ExtentReportUtil.getTest().log(Status.PASS, "Place fetched successfully");
    }

    @Given("DeletePlace Payload with {string}")
    public void deleteplacePayloadWith(String PlaceId) throws IOException {
        log.info("Place with place ID to be deleted-  " + PlaceId);
        ExtentReportUtil.getTest().log(Status.PASS, "Deleting place...");
        res = given().spec(requestSpecification()).body(data.deletePlacePayload(PlaceId));
        log.info(res.toString());
        ExtentReportUtil.getTest().log(Status.PASS, "Place deleted successfully");
    }

    @Given("UpdatePlace Payload with {string}, {string} and key {string}")
    public void updateplacePayloadWithAndKey(String PlaceId, String address, String key) throws IOException {
        log.info("Place with place ID to be updated-  " + PlaceId);
        ExtentReportUtil.getTest().log(Status.PASS, "Updating place...");

        res = given().spec(requestSpecification())
                //	.queryParam("key", "qaclick123")
                .body(data.updatePlacePayload(PlaceId, address, key));
        log.info("This is request body " + res.toString());
        ExtentReportUtil.getTest().log(Status.PASS, "Place updated successfully");
    }
}
