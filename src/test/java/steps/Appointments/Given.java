package steps.Appointments;

import domain.AppointmentStatusEnum;
import dto.AppointmentDTO;
import steps.Base;

import java.util.function.Function;

public abstract class Given<T extends Given<T>> extends Base<T> {

    public static void GivenIHaveAValidPayloadToCreateAppointment(Function<AppointmentStatusEnum, AppointmentDTO> createRequestByAppointmentStatus, AppointmentStatusEnum statusEnum)
    {
        AppointmentDTO data = createRequestByAppointmentStatus.apply(statusEnum);
        System.out.println(ConvertToJson(data));
        requestBody = data;

    }

    protected abstract T getThis();
}
