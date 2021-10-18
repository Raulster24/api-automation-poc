package steps.Appointments;
import steps.Country.Given;
import utilities.RestAssuredExtension;


public abstract class When<T extends steps.Country.When<T>> extends Given<T> {


    public static void WhenICallTheCreateAppointmentEndPoint(String endpoint) {

        System.out.println(accessToken);
        RestAssuredExtension requtil = new RestAssuredExtension(endpoint,accessToken);
        responseObject =requtil.ExecutePostRequest(requestBody);
        System.out.println("the response body is "+ responseObject.body().asString());
        System.out.println(responseObject.getStatusCode());

    }

    public static void WhenICallTheGetAllAppointmentEndPoint(String endpoint) {

        System.out.println(accessToken);
        RestAssuredExtension requtil = new RestAssuredExtension(endpoint,accessToken);
        responseObject =requtil.ExecuteGetRequest();
       // System.out.println("the response body is "+ responseObject.body().asString());
        System.out.println(responseObject.getStatusCode());

    }

    public static void WhenICallTheGetAppointmentByIdEndPoint(String endpoint) {

        System.out.println(accessToken);
        RestAssuredExtension requtil = new RestAssuredExtension(endpoint,accessToken);
        responseObject =requtil.ExecuteGetRequest();
        System.out.println("the response body is "+ responseObject.body().asString());
        System.out.println(responseObject.getStatusCode());

    }

    public static void WhenICallTheUpdateAppointmentEndPoint(String endpoint) {

        System.out.println(accessToken);
        RestAssuredExtension requtil = new RestAssuredExtension(endpoint,accessToken);
        responseObject =requtil.ExecutePutRequest(requestBody);
        System.out.println("the response body is "+ responseObject.getBody().asString());
        System.out.println(responseObject.getStatusCode());

    }

    public static void WhenICallTheActivePastAppointmentEndPoint(String endpoint) {

        System.out.println(accessToken);
        RestAssuredExtension requtil = new RestAssuredExtension(endpoint,accessToken);
        responseObject =requtil.ExecutePostRequest(requestBody);
        System.out.println("the response body is "+ responseObject.body().asString());
        System.out.println(responseObject.getStatusCode());

    }

    public static void WhenICallTheFilterAppointmentEndPoint(String endpoint) {

        System.out.println(accessToken);
        RestAssuredExtension requtil = new RestAssuredExtension(endpoint,accessToken);
        responseObject =requtil.ExecutePostRequest(requestBody);
        System.out.println("the response body is "+ responseObject.body().asString());
        System.out.println(responseObject.getStatusCode());

    }

    public static void WhenICallTheInvalidAppointmentEndPoint(String endpoint) {

        System.out.println(accessToken);
        RestAssuredExtension requtil = new RestAssuredExtension(endpoint,accessToken);
        responseObject =requtil.ExecutePostRequest(requestBody);
        System.out.println("the response body is "+ responseObject.body().asString());
        System.out.println(responseObject.getStatusCode());

    }

    protected abstract T getThis();
}
