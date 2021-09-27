package tests.Country.Payload;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utilities.GenerateAuthToken;

import java.util.stream.Stream;
import static provider.Country.ByCountry.createRequestByCountryNameAndCode;
import static steps.Country.Given.*;
import static steps.Country.Then.ThenCountryShouldBeCreatedSuccessfully;
import static steps.Country.When.WhenICallTheCreateCountryEndPoint;

@TestInstance(Lifecycle.PER_CLASS)
public class CreateCountry {

    @BeforeAll
    void setup() {
        accessToken = new GenerateAuthToken("oauth/token", null).GetToken();
        System.out.println(accessToken);
    }

    @ParameterizedTest
    @MethodSource("CreateCountryValidPayload")
    @DisplayName("Create Country Test Cases")
    void shouldGiveSuccessWithValidValues(String Name, String Code) {
        GivenIHaveAValidPayload(createRequestByCountryNameAndCode, Name, Code);
        WhenICallTheCreateCountryEndPoint("api/countries");
        ThenCountryShouldBeCreatedSuccessfully();
    }


    private static Stream<Arguments> CreateCountryValidPayload() {
        return Stream.of(Arguments.of("India", "IN"));
    }
}
