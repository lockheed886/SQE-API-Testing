package com.api.automation.tests;
import io.restassured.response.Response;

public class ApiResponse {

    private Response response;

    // Constructor to initialize response
    public ApiResponse(Response response) {
        this.response = response;
    }

    // Method to get the response status code
    public int getStatusCode() {
        return response.getStatusCode();
    }

    // Method to get the response body as string
    public String getResponseBody() {
        return response.getBody().asString();
    }

    // Method to get JSON response as a specific object
    public <T> T getResponseBodyAs(Class<T> clazz) {
        return response.getBody().as(clazz);
    }
}

