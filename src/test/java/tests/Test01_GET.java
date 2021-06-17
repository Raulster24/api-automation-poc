package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import steps.Given.*;

import static steps.Given.*;
import static steps.Then.*;
import static steps.When.*;

public class Test01_GET {

    @Test
    @DisplayName("sample test ")
    void validateGetRequest() {
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(response.asString());
        System.out.println(response.body());
        System.out.println(response.statusCode());
        System.out.println(response.getContentType());
    }

}
