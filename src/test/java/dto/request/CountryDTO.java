package dto.request;

import lombok.Builder;
import lombok.Setter;

@Builder
@Setter
public class CountryDTO {
    private String code;
    private int id;
    private String name;
}
