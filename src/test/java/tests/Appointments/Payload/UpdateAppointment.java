package tests.Appointments.Payload;

import domain.AppointmentStatusEnum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import utilities.GenerateAuthToken;

import static steps.Appointments.Given.GivenIHaveAValidPayloadToUpdateAppointment;
import static steps.Appointments.Then.ThenAppointmentShouldBeUpdatedSuccessfully;
import static steps.Appointments.Then.ThenItShouldThrowBadRequestStatusCode;
import static steps.Appointments.When.WhenICallTheUpdateAppointmentEndPoint;
import static steps.Base.accessToken;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UpdateAppointment {

    @BeforeAll
    void setup() {
        accessToken = new GenerateAuthToken("oauth/token", null).GetToken();
        System.out.println(accessToken);
    }

    @ParameterizedTest
    @EnumSource(value = AppointmentStatusEnum.class, names = {"UNAVAILABLE", "ACCEPTED","PENDING", "CANCELLED_BY_PATIENT", "CANCELLED_BY_DOCTOR", "REJECTED"})
    @DisplayName("Update Appointment Test Cases")
    void shouldGiveSuccessWithValidValues(AppointmentStatusEnum statusType) {
        GivenIHaveAValidPayloadToUpdateAppointment(statusType);
        WhenICallTheUpdateAppointmentEndPoint("api/appointments");;
        ThenAppointmentShouldBeUpdatedSuccessfully(statusType);
    }

    @ParameterizedTest
    @EnumSource(value = AppointmentStatusEnum.class, names = {"AVAILABLE"})
    @DisplayName("Update Appointment Test Cases")
    void shouldGiveBadRequestWithStatusTypeAvailable(AppointmentStatusEnum statusType) {
        GivenIHaveAValidPayloadToUpdateAppointment(statusType);
        WhenICallTheUpdateAppointmentEndPoint("api/appointments");;
        ThenItShouldThrowBadRequestStatusCode();
    }
}
