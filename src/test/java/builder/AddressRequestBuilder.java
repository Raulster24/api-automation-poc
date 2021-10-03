package builder;

import dto.request.AddressDTO;
import dto.request.ServiceProvider;

import java.util.function.Supplier;

public class AddressRequestBuilder {

    public static Supplier<AddressDTO> createAddressRequest = () ->
            AddressDTO.builder()
                    .description("test")
                    .id(1)
                    .lat(23.22f)
                    .lon(15.34f)
                    .serviceProvider(ServiceProvider.builder().active(true).picture("sdd").build())
                    .build();
}
