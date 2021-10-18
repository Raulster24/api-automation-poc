package provider.Appointment;

import domain.AppointmentStatusEnum;
import dto.request.ActivePastAppointmentDTO;
import dto.request.AppointmentDTO;
import dto.request.FilterAppointmentDTO;

import java.time.Instant;
import java.time.LocalDate;
import java.util.function.Function;

import static builder.AppointmentRequestBuilder.*;

public class ByAppointmentStatus {
    public static Function<AppointmentStatusEnum, AppointmentDTO> createRequestByAppointmentStatus = (AppointmentStatus) -> {
        AppointmentDTO data = createAppointmentRequest.get();
        data.setStartTime(Instant.now().toString());
        data.setEndTime(Instant.now().plusSeconds(1800).toString());
        data.setStatus(AppointmentStatus);
        return data;
    };

    public static Function<AppointmentStatusEnum, ActivePastAppointmentDTO> createActivePastAppointmentRequestByAppointmentStatus = (AppointmentStatus) -> {
        ActivePastAppointmentDTO data = createActivePastAppointmentRequest.get();
        data.setEndTime(LocalDate.now().plusDays(1).toString() + "T19:59:59.000Z");
        data.setStartTime(LocalDate.now().toString() + "T20:00:00.000Z");
        data.setStatus(AppointmentStatus);
        data.setDoctorId(84);
        return data;
    };

    public static Function<AppointmentStatusEnum, FilterAppointmentDTO> createFilterAppointmentRequestByAppointmentStatus = (AppointmentStatus)-> {
        FilterAppointmentDTO data = createFilterAppointmentRequest.get();
        data.setStatus(AppointmentStatus);
        data.setEndTime(LocalDate.now().plusDays(21).toString() + "T19:59:59.000Z");
        return data;
    };
}
