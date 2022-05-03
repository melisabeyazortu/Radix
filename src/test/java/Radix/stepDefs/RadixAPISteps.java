package Radix.stepDefs;

import Radix.utilies.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class RadixAPISteps {

    String BaseURL= ConfigurationReader.get("apiUrl");
    Response apiUrlResponse;

    @Given("User sends a download request to API")
    public void user_sends_a_download_request_to_api() {
            apiUrlResponse= given().accept(ContentType.JSON)
                    .and().get(BaseURL+"hashes");

        Assert.assertEquals(200, apiUrlResponse.statusCode());


    }

    @Then("The API should return a merkle hashes")
    public void the_api_should_return_a_hash_code() {
       String hash;



        Assert.assertTrue(apiUrlResponse.body().asString().contains("hash"));

    }

    @Then("The merkle hashes should be in json format")
    public void the_merkle_hashes_should_be_in_json_format() {

     //   Assert.assertTrue(apiUrlResponse.contentType().toLowerCase().contains("json"));
    }

    @Then("The API should return number of pieces of the files")
    public void the_api_should_return_number_of_pieces_of_the_files() {
        int pieces;

        pieces=apiUrlResponse.path("pieces");
        System.out.println("pieces = " + pieces);
    }

}