package tests.Country.Payload;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;
import static provider.Country.ByCountry.createRequestByCountryNameAndCode;
import static steps.Given.*;
import static steps.When.WhenICallTheCreateCountryEndPoint;

public class CreateCountry {

    @ParameterizedTest
    @MethodSource("CreateCountryValidPayload")
    @DisplayName("Create Country Test Cases")
    void shouldGiveSuccessWithValidValues(String Name, String Code) {
        GivenIHaveAValidPayload(createRequestByCountryNameAndCode, Name, Code);
        WhenICallTheCreateCountryEndPoint("/api/countries");


    }

    private static Stream<Arguments> CreateCountryValidPayload() {
        return Stream.of(Arguments.of("India", "IN"),
                Arguments.of("United Kingdom", "UK"),
                Arguments.of("France", "FR"));
    }
}
