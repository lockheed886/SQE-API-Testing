package com.api.automation.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

class JsonPlaceholderTest {

    @BeforeAll
    static void setup() {
        // Setting Base URI for JSONPlaceholder
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    void testGetPosts() {
        // GET request for posts
        Response response = given()
                                .when()
                                .get("/posts/1")
                                .then()
                                .statusCode(200)
                                .contentType(ContentType.JSON)
                                .extract().response();
        
        // Asserting the response has userId and title
        assertNotNull(response.jsonPath().get("userId"));
        assertNotNull(response.jsonPath().get("title"));
    }

    @Test
    void testCreatePost() {
        // JSON Object for POST request body
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "foo");
        requestBody.put("body", "bar");
        requestBody.put("userId", 1);

        // POST request to create a post
        Response response = given()
                                .contentType(ContentType.JSON)
                                .body(requestBody.toString())
                                .when()
                                .post("/posts")
                                .then()
                                .statusCode(201)
                                .extract().response();

        // Verifying the response
        assertEquals("foo", response.jsonPath().get("title"));
    }

    @Test
    void testUpdatePost() {
        // JSON Object for PATCH request body
        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "updated title");

        // PATCH request to update a post
        Response response = given()
                                .contentType(ContentType.JSON)
                                .body(requestBody.toString())
                                .when()
                                .patch("/posts/1")
                                .then()
                                .statusCode(200)
                                .extract().response();

        // Verifying the response
        assertEquals("updated title", response.jsonPath().get("title"));
    }

    @Test
    void testHeadPosts() {
        // HEAD request to check headers for /posts
        Response response = given()
                                .when()
                                .head("/posts")
                                .then()
                                .statusCode(200)
                                .extract().response();

        // Asserting response has headers
        assertNotNull(response.getHeader("Content-Type"));
        assertEquals("application/json; charset=utf-8", response.getHeader("Content-Type"));
    }
}
