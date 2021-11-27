package org.example.rest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;

public class RestTest {

    @Test
    public void getTest() {
        RestAssured.
                when().get("https://reqres.in/api/single_user").
                then().assertThat().statusCode(200).
                and().body("args.first_name", is("Janet"));
    }
}
