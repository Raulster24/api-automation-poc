package steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utilities.GenerateAuthToken;
import utilities.RestAssuredExtension;


public abstract class When<T extends When<T>> extends Given<T>{


    public static void WhenICallTheCreateCountryEndPoint(String endpoint) {

    System.out.println(accessToken);
     RestAssuredExtension requtil = new RestAssuredExtension(endpoint,accessToken);
     responseObject =requtil.ExecuteGetRequest();
     System.out.println("the response body is "+ responseObject.body().asString());
     System.out.println(responseObject.getStatusCode());

    }

    public static void WhenICallTheGetAllCountryEndPoint(String endpoint) {
        RestAssuredExtension requtil = new RestAssuredExtension(endpoint,accessToken);
        responseObject =requtil.ExecuteGetRequest();
        System.out.println("the response body is "+ responseObject.body().asString());
        System.out.println(responseObject.getStatusCode());

    }
    protected abstract T getThis();
}
