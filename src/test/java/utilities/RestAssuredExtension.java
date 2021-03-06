package utilities;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveAuthProvider;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class RestAssuredExtension {
    protected RequestSpecBuilder builder = new RequestSpecBuilder();
    public String baseUrl;

    public RestAssuredExtension(String uri, String accessToken) {

        this.baseUrl = "https://dev.healthieru.ae/" + uri;
        if(accessToken!= null) {
            authentication = oauth2(accessToken);
            builder.setAuth(authentication);
        }
    }

    public ResponseOptions<Response> ExecutePostRequest() {
        builder.addHeader("Accept", ContentType.JSON.getAcceptHeader());
        RequestSpecification requestSpecification = builder.build();
        RequestSpecification request = RestAssured.given();
        request.spec(requestSpecification);
        return request.post(this.baseUrl);
    }

   public ResponseOptions<Response> ExecutePostRequest(Object Payload) {
        builder.addHeader("Accept", ContentType.JSON.getAcceptHeader());
        builder.setBody(Payload);
        builder.setContentType(ContentType.JSON);
        RequestSpecification requestSpecification = builder.build();
        RequestSpecification request = RestAssured.given();
        request.spec(requestSpecification);
        return request.post(this.baseUrl);
    }

    public ResponseOptions<Response> ExecutePutRequest(Object Payload) {
        builder.addHeader("Accept", ContentType.JSON.getAcceptHeader());
        builder.setBody(Payload);
        builder.setContentType(ContentType.JSON);
        RequestSpecification requestSpecification = builder.build();
        RequestSpecification request = RestAssured.given();
        request.spec(requestSpecification);
        return request.put(this.baseUrl);
    }

    public ResponseOptions<Response> ExecuteGetRequest() {
        builder.addHeader("Accept", ContentType.JSON.getAcceptHeader());
        RequestSpecification requestSpecification = builder.build();
        RequestSpecification request = RestAssured.given();
        request.spec(requestSpecification);
        return request.log().all().get(this.baseUrl);
    }

    public ResponseOptions<Response> ExecuteUpdateRequestWithPayload(String Payload) {
        builder.addHeader("Accept", ContentType.JSON.getAcceptHeader());
        builder.addMultiPart("profileData", Payload);
        RequestSpecification requestSpecification = builder.build();
        RequestSpecification request = RestAssured.given();
        request.spec(requestSpecification);
        return request.log().all().put(this.baseUrl);
    }
}