package dto.request;

import lombok.Builder;
import lombok.Setter;

@Builder
@Setter
public class InvalidAppointmentDTO {
    public Integer doctorId;
    public String startTime;
    public String endTime;
}