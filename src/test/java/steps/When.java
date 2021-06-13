package steps;

public abstract class When<T extends When<T>> extends Given<T>{

    public static void WhenICallTheCreateCountryEndPoint(String Endpoint) {

    }

    public static void WhenICallTheGetCountryEndPoint(String Endpoint) {

    }
    protected abstract T getThis();
}
