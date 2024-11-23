package com.api.automation.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ApiTest {

    // Test for GET request
    @Test
    public void testGetUsers() {
        ApiResponse response = new ApiResponse(ApiRequest.sendGetRequest(ApiEndpoints.GET_USERS));

        // Assert the response status code
        assertEquals(200, response.getStatusCode());

        // Optionally, check the response body content
        assertTrue(response.getResponseBody().contains("Leanne Graham"));
    }

    // Test for POST request
    @Test
    public void testCreateUser() {
        String requestBody = "{ \"name\": \"John Doe\", \"email\": \"johndoe@example.com\" }";
        ApiResponse response = new ApiResponse(ApiRequest.sendPostRequest(ApiEndpoints.POST_USER, requestBody));

        // Assert the response status code
        assertEquals(201, response.getStatusCode());

        // Assert the response body contains the new user's name
        assertTrue(response.getResponseBody().contains("John Doe"));
    }

    // Test for PATCH request
    @Test
    public void testUpdateUser() {
        String requestBody = "{ \"name\": \"Updated Name\" }";
        ApiResponse response = new ApiResponse(ApiRequest.sendPatchRequest(ApiEndpoints.PATCH_USER, requestBody));

        // Assert the response status code
        assertEquals(200, response.getStatusCode());

        // Assert the updated name is present in the response
        assertTrue(response.getResponseBody().contains("Updated Name"));
    }

    // Test for HEAD request
    @Test
    public void testHeadRequest() {
        ApiResponse response = new ApiResponse(ApiRequest.sendHeadRequest(ApiEndpoints.HEAD_USERS));

        // Assert the response status code
        assertEquals(200, response.getStatusCode());

        // HEAD requests usually don't have a body, so you might only check the headers
        assertNotNull(response.getResponseBody()); // Should ideally be empty for HEAD requests
        assertTrue(response.getResponseBody().isEmpty());
    }
}

