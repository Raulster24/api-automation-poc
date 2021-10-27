package tests.Patients.Payload;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import utilities.GenerateAuthToken;

import static steps.Appointments.Given.*;
import static steps.Appointments.Then.ThenPatientDetailsShouldBeFetchedSuccessfully;
import static steps.Appointments.When.WhenICallTheGetAllPatientEndPoint;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GetAllPatients {

    @BeforeAll
    void setup() {
        accessToken = new GenerateAuthToken("oauth/token", null).GetToken();
        System.out.println(accessToken);
    }

    @Test
    @DisplayName("Get All Patients Endpoint Test Cases")
    void shouldBeAbleToGetAppointmentsSuccessfully() {
        WhenICallTheGetAllPatientEndPoint("api/admin/patients");
        ThenPatientDetailsShouldBeFetchedSuccessfully();
    }
}
