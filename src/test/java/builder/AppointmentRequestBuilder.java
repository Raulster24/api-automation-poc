package builder;

import domain.AppointmentStatusEnum;
import domain.AppointmentTypeEnum;
import dto.request.ActivePastAppointmentDTO;
import dto.request.AppointmentDTO;
import dto.request.FilterAppointmentDTO;
import dto.request.InvalidAppointmentDTO;

import java.util.function.Supplier;

public class AppointmentRequestBuilder {

    public static Supplier<AppointmentDTO> createAppointmentRequest = () ->
            AppointmentDTO.builder()
                    .id(null)
                    .doctorId(182)
                    .type(AppointmentTypeEnum.DR)
                    .status(AppointmentStatusEnum.AVAILABLE)
                    .remarks(null)
                    .timeZone("Asia/Dubai").build();

    public static Supplier<ActivePastAppointmentDTO> createActivePastAppointmentRequest = () ->
            ActivePastAppointmentDTO.builder()
            .doctorId(182)
            .status(AppointmentStatusEnum.AVAILABLE)
            .startTime(null)
            .endTime(null)
            .build();

    public static Supplier<FilterAppointmentDTO> createFilterAppointmentRequest = () ->
            FilterAppointmentDTO.builder()
            .patientId(148)
            .endTime(null)
            .status(null)
            .build();

    public static Supplier<InvalidAppointmentDTO> createInvalidAppointmentRequest = () ->
            InvalidAppointmentDTO.builder()
            .doctorId(88)
            .endTime(null)
            .startTime(null)
            .build();

}
