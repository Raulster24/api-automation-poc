package data;

import static utilities.ReadJsonAsString.readFileAsString;

public class UpdateDoctorInvalidPayload {

    public static final String CREATE_DOCTOR_INVALID_RATE = readFileAsString("src/test/resources/RequestPayload/createDoctor_InvalidPayload_InvalidRate.json");
    public static final String CREATE_DOCTOR_NUll_RATE_AND_HALF_RATE = readFileAsString("src/test/resources/RequestPayload/createDoctor_invalidPayload_nullRateAndHalfRate.json");
    public static final String CREATE_DOCTOR_INVALID_HALF_RATE = readFileAsString("src/test/resources/RequestPayload/createDcotor_InvalidPayload_InvalidHalfRate.json");

}
