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

    // Method to send a PUT request
    public static Response sendPutRequest(String endpoint, String requestBody) {
        return given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put(endpoint)
                .then()
                .extract()
                .response();
    }

    // Method to send a DELETE request
    public static Response sendDeleteRequest(String endpoint) {
        return given()
                .when()
                .delete(endpoint)
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
    
    // Method to send an OPTIONS request
    public static Response sendOptionsRequest(String endpoint) {
        return given()
                .when()
                .options(endpoint)
                .then()
                .extract()
                .response();
    }

 // Method to send a TRACE request
    public static Response sendTraceRequest(String endpoint) {
        return given()
                .when()
                .request("TRACE", endpoint)
                .then()
                .extract()
                .response();
    }

}
