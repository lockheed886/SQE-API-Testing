package com.api.automation.tests;

import io.restassured.response.Response;

public class ApiResponse {

    private Response response;

    public ApiResponse(Response response) {
        this.response = response;
    }

    public int getStatusCode() {
        return response.getStatusCode();
    }

    public String getResponseBody() {
        return response.getBody() != null ? response.getBody().asString() : "";
    }

    public <T> T getResponseBodyAs(Class<T> clazz) {
        if (response.getBody() != null && !response.getBody().asString().isEmpty()) {
            return response.getBody().as(clazz);
        }
        return null;
    }

    public String getHeader(String headerName) {
        return response.getHeader(headerName);
    }

    public boolean isResponseBodyEmpty() {
        return response.getBody() == null || response.getBody().asString().isEmpty();
    }
}
