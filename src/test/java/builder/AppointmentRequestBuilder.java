package builder;

import domain.AppointmentStatusEnum;
import domain.AppointmentTypeEnum;
import dto.request.AppointmentDTO;

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

}
