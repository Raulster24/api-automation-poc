package tests.Appointments.Payload;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import utilities.GenerateAuthToken;

import static steps.Appointments.Given.*;
import static steps.Appointments.Then.*;
import static steps.Appointments.When.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InvalidAppointment {

    @BeforeAll
    void setup() {
        accessToken = new GenerateAuthToken("oauth/token", null).GetToken();
        System.out.println(accessToken);
    }
    @Test
    @DisplayName("Invalid Appointment Test Cases")
    void shouldGiveSuccessWithValidValues() {
        GivenIHaveValidPayloadToInvalidAppointment();
        WhenICallTheInvalidAppointmentEndPoint("api/appointments/invalid");
        ThenItShouldFetchAllInvalidAppointmentAsResponse();
    }
}
