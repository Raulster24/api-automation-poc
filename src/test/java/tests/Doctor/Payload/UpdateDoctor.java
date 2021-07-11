package tests.Doctor.Payload;

import data.UpdateDoctorInvalidPayload;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utilities.GenerateAuthToken;

import java.util.stream.Stream;

import static steps.Base.accessToken;
import static steps.Given.GivenIHaveAValidPayload;
import static steps.Then.ThenItShouldThrowBadRequestStatusCode;
import static steps.When.WhenICallUpdateDoctorEndPoint;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UpdateDoctor {

    @BeforeAll
    void setup() {
        accessToken = new GenerateAuthToken("oauth/token", null).GetToken();
        System.out.println(accessToken);
    }

    @ParameterizedTest
    @MethodSource("UpdateDoctorInvalidPayload")
    @DisplayName("Update Doctor Test Cases")
    void shouldGiveBadRequestWithInvalidValues(String jsonPayload) {
        GivenIHaveAValidPayload(jsonPayload);
        WhenICallUpdateDoctorEndPoint("api/admin/doctors");
        ThenItShouldThrowBadRequestStatusCode();
    }


    private static Stream<Arguments> UpdateDoctorInvalidPayload() {
        return Stream.of(Arguments.of(UpdateDoctorInvalidPayload.CREATE_DOCTOR_INVALID_RATE),
                Arguments.of(UpdateDoctorInvalidPayload.CREATE_DOCTOR_INVALID_HALF_RATE),
                Arguments.of(UpdateDoctorInvalidPayload.CREATE_DOCTOR_NUll_RATE_AND_HALF_RATE));
    }

}
