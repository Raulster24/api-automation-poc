package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
