package steps.Appointments;

import org.junit.jupiter.api.Assertions;
import steps.Country.When;

public abstract class Then<T extends steps.Country.Then<T>> extends When<T> {

    public static void ThenAppointmentShouldBeCreatedSuccessfully() {
        Assertions.assertEquals(responseObject.getStatusCode(), 400);
        Assertions.assertNotNull(responseObject, "The Response Object is null");

    }

    public static void ThenItShouldThrowBadRequestStatusCode() {
        Assertions.assertEquals(responseObject.getStatusCode(), 400);
        Assertions.assertNotNull(responseObject, "The Response Object is null");
    }
}
