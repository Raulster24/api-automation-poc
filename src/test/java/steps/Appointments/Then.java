package steps.Appointments;

import domain.AppointmentStatusEnum;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import steps.Country.When;

public abstract class Then<T extends steps.Country.Then<T>> extends When<T> {

    public static void ThenAppointmentShouldBeCreatedSuccessfully() {
        Assertions.assertEquals(201, responseObject.getStatusCode() );
        Assertions.assertNotNull(responseObject, "The Response Object is null");
        Assertions.assertNotNull(responseObject.getBody(), "The Response body is null" );

    }

    public static void ThenItShouldThrowBadRequestStatusCode() {
        Assertions.assertEquals(400, responseObject.getStatusCode());
        Assertions.assertNotNull(responseObject, "The Response Object is null");
        Assertions.assertNotNull(responseObject.getBody(), "The Response body is null" );
    }

    public static void ThenItShouldThrowErrorStatusCode() {
        Assertions.assertEquals(500, responseObject.getStatusCode());
        Assertions.assertNotNull(responseObject, "The Response Object is null");
        Assertions.assertNotNull(responseObject.getBody(), "The Response body is null" );
    }

    public static void ThenAppointmentByIdShouldBeFetchedSuccessfully() {
        Assertions.assertEquals(200, responseObject.getStatusCode());
        Assertions.assertNotNull(responseObject, "The Response Object is null");
        Assertions.assertNotNull(responseObject.getBody().asString(), "The Response body is null" );

    }
    public static void ThenAppointmentShouldBeFetchedSuccessfully() {
        Assertions.assertEquals(200, responseObject.getStatusCode());
        Assertions.assertNotNull(responseObject, "The Response Object is null");
        Assertions.assertNotNull(responseObject.getBody().asString(), "The Response body is null" );
        Assertions.assertNotNull(responseObject.getBody().path("[0].id"), "Response body is empty array");

    }

    public static void ThenItShouldThrowNotFoundErrorCode() {
        Assertions.assertEquals(404, responseObject.getStatusCode());
        Assertions.assertNotNull(responseObject, "The Response Object is null");
        Assertions.assertNotNull(responseObject.getBody(), "The Response body is null" );
    }

    public static void ThenAppointmentShouldBeUpdatedSuccessfully(AppointmentStatusEnum statusType) {
        Assertions.assertEquals(200, responseObject.getStatusCode());
        Assertions.assertEquals(statusType.toString(), responseObject.getBody().path("[0].status"));
        Assertions.assertNotNull(responseObject.getBody(), "The Response body is null" );
    }

    public static void ThenItShouldFetchAllInvalidAppointmentAsResponse() {
        Assertions.assertEquals(200, responseObject.getStatusCode());
        Assertions.assertNotNull(responseObject, "The Response Object is null");
        Assertions.assertNotNull(responseObject.getBody().asString(), "The Response body is null" );
        Assertions.assertNotNull(responseObject.getBody().path("[0]"), "Response body is empty array");
    }
}
