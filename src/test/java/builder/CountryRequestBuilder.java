package builder;

import dto.request.CountryDTO;
import java.util.function.Supplier;

public class CountryRequestBuilder {
    public static Supplier<CountryDTO> createCountryRequest = () ->
            CountryDTO.builder()
            .code("US")
            .id(244)
            .name("United States").build();
}
