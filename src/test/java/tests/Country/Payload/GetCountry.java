package tests.Country.Payload;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.TestInstance;
import utilities.GenerateAuthToken;

import static steps.Base.*;
import static steps.Then.*;
import static steps.When.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GetCountry {

    @BeforeAll
    void setup() {
        accessToken = new GenerateAuthToken("oauth/token", null).GetToken();
        System.out.println(accessToken);
    }

    @Test
    @DisplayName("Get Country Test Cases")
    void shouldGiveSuccess() {
        WhenICallTheGetAllCountryEndPoint("api/countries");
        ThenCountriesShouldBeFetchedSuccessfully();
    }
}
