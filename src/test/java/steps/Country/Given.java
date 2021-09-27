package steps;

import dto.CountryDTO;

import java.util.function.BiFunction;

public abstract class Given<T extends Given<T>> extends Base<T> {

    public static void GivenIHaveAValidPayload(BiFunction<String, String, CountryDTO> createRequestByCountryNameAndCode, String Name, String Code)
    {
        CountryDTO data = createRequestByCountryNameAndCode.apply(Name, Code);
        System.out.println(ConvertToJson(data));
        requestBody = data;

    }

    public static void GivenIHaveAValidPayload(String createDoctorStringPayload)
    {
        requestBodyAsString = createDoctorStringPayload;

    }

        protected abstract T getThis();
    }
