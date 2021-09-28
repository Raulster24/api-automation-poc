package tests.Appointments.Payload;

import domain.AppointmentStatusEnum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import utilities.GenerateAuthToken;

import static provider.Appointment.ByAppointmentStatus.createRequestByAppointmentStatus;
import static steps.Appointments.Given.*;
import static steps.Appointments.Then.*;
import static steps.Appointments.When.*;

@TestInstance(Lifecycle.PER_CLASS)
public class CreateAppointment {

    @BeforeAll
    void setup() {
        accessToken = new GenerateAuthToken("oauth/token", null).GetToken();
        System.out.println(accessToken);
    }

    @ParameterizedTest
    @EnumSource(names = {"AVAILABLE"})
    @DisplayName("Create Appointment Test Cases")
    void shouldGiveSuccessWithValidValues(AppointmentStatusEnum statusType) {
        GivenIHaveAValidPayloadToCreateAppointment(createRequestByAppointmentStatus, statusType);
        WhenICallTheCreateAppointmentEndPoint("api/appointments");
        ThenAppointmentShouldBeCreatedSuccessfully();
    }

    @ParameterizedTest
    @EnumSource(names = {"PENDING"})
    @DisplayName("Create Appointment Test Cases")
    void shouldGiveBadRequestWithInvalidValues(AppointmentStatusEnum statusType) {
        GivenIHaveAValidPayloadToCreateAppointment(createRequestByAppointmentStatus, statusType);
        WhenICallTheCreateAppointmentEndPoint("api/appointments");
        ThenItShouldThrowBadRequestStatusCode();
    }
}
