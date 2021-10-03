package provider.Appointment;

import domain.AppointmentStatusEnum;
import dto.request.AppointmentDTO;

import java.time.Instant;
import java.util.function.Function;

import static builder.AppointmentRequestBuilder.createAppointmentRequest;

public class ByAppointmentStatus {
    public static Function<AppointmentStatusEnum, AppointmentDTO> createRequestByAppointmentStatus = (AppointmentStatus) -> {
        AppointmentDTO data = createAppointmentRequest.get();
        data.setStartTime(Instant.now().toString());
        data.setEndTime(Instant.now().plusSeconds(1800).toString());
        data.setStatus(AppointmentStatus);
        return data;
    };
}
