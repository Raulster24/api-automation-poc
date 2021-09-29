package tests.Appointments.Payload;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import utilities.GenerateAuthToken;

import static steps.Appointments.Then.ThenAppointmentShouldBeFetchedSuccessfully;
import static steps.Appointments.When.WhenICallTheGetAllAppointmentEndPoint;
import static steps.Appointments.When.WhenICallTheGetAppointmentByIdEndPoint;
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
}