package steps;

import com.google.gson.*;

public abstract class Base <T extends Base<T>> {

    public static Object requestBody;

    public static String ConvertToJson(Object requestBody) {
    return new Gson().toJson(requestBody);

    }
    protected abstract T getThis();
}
