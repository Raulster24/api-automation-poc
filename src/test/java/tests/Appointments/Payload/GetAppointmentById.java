package tests.Appointments.Payload;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import utilities.GenerateAuthToken;

import static steps.Appointments.Then.*;
import static steps.Appointments.When.*;
import static steps.Base.accessToken;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GetAppointmentById {

    @BeforeAll
    void setup() {
        accessToken = new GenerateAuthToken("oauth/token", null).GetToken();
        System.out.println(accessToken);
    }

    @Test
    @DisplayName("Get Appointment By Id Test Cases")
    void shouldBeAbleToGetAppointmentByIdSuccessfully() {
        WhenICallTheGetAppointmentByIdEndPoint("api/appointments/2522");
        ThenAppointmentShouldBeFetchedSuccessfully();
    }

    @Test
    @DisplayName("Get Appointment By Id Test Cases")
    void shouldThrowNotFoundErrorOnInvalidId() {
        WhenICallTheGetAppointmentByIdEndPoint("api/appointments/25222222");
        ThenItShouldThrowNotFoundErrorCode();
    }
}