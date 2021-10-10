package dto.request;

import domain.AppointmentStatusEnum;
import lombok.Builder;
import lombok.Setter;

@Builder
@Setter
public class ActivePastAppointmentDTO {

    public Integer doctorId;
    public AppointmentStatusEnum status;
    public String startTime;
    public String endTime;
}
