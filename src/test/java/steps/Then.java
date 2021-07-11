package steps;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public abstract class Then<T extends Then<T>> extends When<T>{

    public static void ThenCountryShouldBeCreatedSuccessfully() {
        Assertions.assertEquals(responseObject.getStatusCode(), 200);
        Assertions.assertNotNull(responseObject, "The Response Object is null");

    }

    public static void ThenCountriesShouldBeFetchedSuccessfully() {
        Assertions.assertEquals(responseObject.getStatusCode(), 200);
        Assertions.assertNotNull(responseObject, "The Response Object is null");
    }

    public static void ThenItShouldThrowBadRequestStatusCode() {
        Assertions.assertEquals(responseObject.getStatusCode(), 400);
        Assertions.assertNotNull(responseObject, "The Response Object is null");
    }

}
