package provider.Country;

import dto.CountryDTO;
import java.util.function.BiFunction;
import static builder.CountryRequestBuilder.createCountryRequest;

public class ByCountry {

    public static BiFunction<String,String, CountryDTO> createRequestByCountryNameAndCode  = (name, code) -> {
        CountryDTO data = createCountryRequest.get();
        data.setName(name);
        data.setCode(code);
        return data;
    };

}
