package tests;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;


public class OAuthTest {

    static String access_token;
    static String userName = "admin";
    static String password = "Welcomeadmin%40G42321%24";

    @Test
    void getAccessToken() {
        Response response = given()
               .auth()
                .preemptive()
                .basic("web_app", "changeit")
                .header("Accept",ContentType.JSON.getAcceptHeader() )
               .queryParam("username", "admin")
               .queryParam("password", "Welcomeadmin@G42321$")
                .queryParam("grant_type", "password")
                .queryParam("scope", "openid")
                .log().all()
                .post("https://dev.healthy-u.ae/oauth/token");
        Assertions.assertNotNull(response, "Response body is null");
        response.prettyPrint();
        System.out.println(response.statusCode());

    }
}
