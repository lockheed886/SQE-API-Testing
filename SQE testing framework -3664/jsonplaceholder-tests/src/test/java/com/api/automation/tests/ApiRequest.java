package com.api.automation.tests;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ApiRequest {

    // Method to send a GET request
    public static Response sendGetRequest(String endpoint) {
        return given()
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();
    }

    // Method to send a POST request
    public static Response sendPostRequest(String endpoint, String requestBody) {
        return given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();
    }

    // Method to send a PATCH request
    public static Response sendPatchRequest(String endpoint, String requestBody) {
        return given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .patch(endpoint)
                .then()
                .extract()
                .response();
    }

    // Method to send a HEAD request
    public static Response sendHeadRequest(String endpoint) {
        return given()
                .when()
                .head(endpoint)
                .then()
                .extract()
                .response();
    }
}

