package dto;

import lombok.Builder;

@Builder
public class ServiceProvider {
    private Long id;
    private String title;
    private String description;
    private Float lon;
    private Float lat;
    private Boolean active;
    private String picture;
}
