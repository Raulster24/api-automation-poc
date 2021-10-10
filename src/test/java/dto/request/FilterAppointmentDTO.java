package dto.request;

import domain.AppointmentStatusEnum;
import lombok.Builder;
import lombok.Setter;

@Builder
@Setter
public class FilterAppointmentDTO {
    public Integer patientId;
    public AppointmentStatusEnum status;
    public String endTime;
}