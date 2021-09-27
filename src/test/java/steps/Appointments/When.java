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


    protected abstract T getThis();
}
