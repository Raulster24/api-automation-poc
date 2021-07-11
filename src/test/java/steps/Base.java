package steps;

import com.google.gson.*;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

public abstract class Base <T extends Base<T>> {

    public static Object requestBody;
    public static String requestBodyAsString;
    public static ResponseOptions<Response> responseObject;
    public static String accessToken;

    public static String ConvertToJson(Object requestBody) {
    return new Gson().toJson(requestBody);

    }

    protected abstract T getThis();
}
