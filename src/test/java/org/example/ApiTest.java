package org.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ApiTest {

    @Test
    public void testGetRequest() {
        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");

        assertEquals(200, response.getStatusCode(), "Status code not 200!");

        assertNotNull(response.jsonPath().get("userId"), "cannot find userId!");
    }
}
