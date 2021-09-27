package builder;

import domain.AppointmentStatusEnum;
import domain.AppointmentTypeEnum;
import dto.AppointmentDTO;

import java.time.Instant;
import java.util.function.Supplier;

public class AppointmentRequestBuilder {

    public static Supplier<AppointmentDTO> createAppointmentRequest = () ->
            AppointmentDTO.builder()
                    .doctorId(182)
                    .type(AppointmentTypeEnum.DR)
                    .status(AppointmentStatusEnum.AVAILABLE)
                    .remarks(null)
                    .timeZone("Asia/Dubai").build();

}
