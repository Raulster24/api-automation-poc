package utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.preemptive;

public class GenerateAuthToken extends RestAssuredExtension {

    public GenerateAuthToken(String uri, String accessToken) {
        super("oauth/token", null);
    }

    public String GetToken(){
        RestAssured.authentication = preemptive().basic("web_app", "changeit");
        builder
                .setAuth(authentication)
                .addHeader("Accept", ContentType.JSON.getAcceptHeader() )
                .addQueryParam("username", "admin")
                .addQueryParam("password", "Welcomeadmin@G42321$")
                .addQueryParam("grant_type", "password");
        return ExecutePostRequest().getBody().path("access_token");
    }
}
