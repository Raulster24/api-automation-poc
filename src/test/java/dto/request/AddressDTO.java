package dto.request;

import lombok.*;

@Builder
public class AddressDTO {
    private String description;
    private int id;
    private float lat;
    private float lon;
    private ServiceProvider serviceProvider;
}
