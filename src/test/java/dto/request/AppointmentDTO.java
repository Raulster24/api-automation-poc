package dto.request;

import domain.AppointmentStatusEnum;
import domain.AppointmentTypeEnum;
import lombok.Builder;
import lombok.Setter;

import java.time.Instant;

@Builder
@Setter
public class AppointmentDTO {
    public Integer id;
    public Integer doctorId;
    public AppointmentTypeEnum type;
    public AppointmentStatusEnum status;
    public String remarks;
    public String startTime;
    public String endTime;
    public String timeZone;
}
