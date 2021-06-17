package tests.Country.Payload;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static steps.When.WhenICallTheGetCountryEndPoint;

public class GetCountry {

    @Test
    @DisplayName("Get Country Test Cases")
    void shouldGiveSuccessOnFetchingCountries() {
        WhenICallTheGetCountryEndPoint("/countries");
    }
}
