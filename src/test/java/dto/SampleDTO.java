package dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SampleDTO {

    private Double amount;
    private Double quoteId;
    private String name;
}
