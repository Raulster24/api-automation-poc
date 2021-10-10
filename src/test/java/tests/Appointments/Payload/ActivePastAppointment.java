package tests.Appointments.Payload;

import domain.AppointmentStatusEnum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import utilities.GenerateAuthToken;

import static provider.Appointment.ByAppointmentStatus.createActivePastAppointmentRequestByAppointmentStatus;
import static steps.Appointments.Given.*;
import static steps.Appointments.Then.ThenAppointmentShouldBeFetchedSuccessfully;
import static steps.Appointments.When.WhenICallTheActivePastAppointmentEndPoint;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ActivePastAppointment {

    @BeforeAll
    void setup() {
        accessToken = new GenerateAuthToken("oauth/token", null).GetToken();
        System.out.println(accessToken);
    }

    @ParameterizedTest
    @EnumSource(value = AppointmentStatusEnum.class, names = {"AVAILABLE"})
    @DisplayName("Create Appointment Test Cases")
    void shouldGiveSuccessWithValidValues(AppointmentStatusEnum statusType) {
        GivenIHaveAValidPayloadToGetActivePastAppointment(createActivePastAppointmentRequestByAppointmentStatus,statusType);
        WhenICallTheActivePastAppointmentEndPoint("api/appointments/active-past");
        ThenAppointmentShouldBeFetchedSuccessfully();
    }
}
