package com.api.automation.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ApiTest {

    @Test
    public void testGetUsers() {
        ApiResponse response = new ApiResponse(ApiRequest.sendGetRequest(ApiEndpoints.GET_USERS));
        assertEquals(200, response.getStatusCode());
        assertTrue(response.getResponseBody().contains("Leanne Graham"));
    }

    @Test
    public void testCreateUser() {
        String requestBody = "{ \"name\": \"John Doe\", \"email\": \"johndoe@example.com\" }";
        ApiResponse response = new ApiResponse(ApiRequest.sendPostRequest(ApiEndpoints.POST_USER, requestBody));
        assertEquals(201, response.getStatusCode());
        assertTrue(response.getResponseBody().contains("John Doe"));
    }

    @Test
    public void testUpdateUser() {
        String requestBody = "{ \"name\": \"Updated Name\", \"email\": \"updatedemail@example.com\" }";
        ApiResponse response = new ApiResponse(ApiRequest.sendPutRequest(ApiEndpoints.PUT_USER, requestBody));
        assertEquals(200, response.getStatusCode());
        assertTrue(response.getResponseBody().contains("Updated Name"));
        assertTrue(response.getResponseBody().contains("updatedemail@example.com"));
    }

    @Test
    public void testDeleteUser() {
        ApiResponse response = new ApiResponse(ApiRequest.sendDeleteRequest(ApiEndpoints.DELETE_USER));
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void testPatchUser() {
        String requestBody = "{ \"name\": \"Updated Name\" }";
        ApiResponse response = new ApiResponse(ApiRequest.sendPatchRequest(ApiEndpoints.PATCH_USER, requestBody));
        assertEquals(200, response.getStatusCode());
        assertTrue(response.getResponseBody().contains("Updated Name"));
    }

    @Test
    public void testHeadRequest() {
        ApiResponse response = new ApiResponse(ApiRequest.sendHeadRequest(ApiEndpoints.HEAD_USERS));
        assertEquals(200, response.getStatusCode());
        assertNotNull(response.getResponseBody());
        assertTrue(response.getResponseBody().isEmpty());
    }

    @Test
    public void testOptionsRequest() {
        ApiResponse response = new ApiResponse(ApiRequest.sendOptionsRequest(ApiEndpoints.GET_USERS));
        System.out.println("Actual Status Code: " + response.getStatusCode());
        System.out.println("Allow Header: " + response.getResponseBody());
        assertEquals(204, response.getStatusCode());
        assertTrue(response.getResponseBody().isEmpty());
        assertFalse(response.getResponseBody().contains("Allow"));
    }

    @Test
    public void testTraceRequest() {
        ApiResponse response = new ApiResponse(ApiRequest.sendTraceRequest(ApiEndpoints.GET_USERS));
        System.out.println("Actual Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getResponseBody());
        assertEquals(405, response.getStatusCode());
        assertTrue(response.getResponseBody().contains("Not Allowed"));
    }
}
