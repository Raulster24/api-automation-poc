package steps.Appointments;

import domain.AppointmentStatusEnum;
import dto.request.ActivePastAppointmentDTO;
import dto.request.AppointmentDTO;
import dto.request.FilterAppointmentDTO;
import dto.request.InvalidAppointmentDTO;
import steps.Base;

import java.time.LocalDate;
import java.util.function.Function;

import static builder.AppointmentRequestBuilder.createInvalidAppointmentRequest;
import static provider.Appointment.ByAppointmentStatus.createRequestByAppointmentStatus;
import static steps.Appointments.When.WhenICallTheCreateAppointmentEndPoint;

public abstract class Given<T extends Given<T>> extends Base<T> {

    public static void GivenIHaveAValidPayloadToCreateAppointment(Function<AppointmentStatusEnum, AppointmentDTO> createRequestByAppointmentStatus, AppointmentStatusEnum statusEnum)
    {
        AppointmentDTO data = createRequestByAppointmentStatus.apply(statusEnum);
        System.out.println(ConvertToJson(data));
        requestBody = data;

    }

    public static void GivenIHaveAValidPayloadToUpdateAppointment(AppointmentStatusEnum statusEnum)
    {
        GivenIHaveAValidPayloadToCreateAppointment(createRequestByAppointmentStatus, AppointmentStatusEnum.AVAILABLE);
        WhenICallTheCreateAppointmentEndPoint("api/appointments");
        AppointmentDTO data = createRequestByAppointmentStatus.apply(statusEnum);
        data.setId(responseObject.body().path("id"));
        data.setStartTime(responseObject.body().path("startTime"));
        data.setEndTime(responseObject.body().path("endTime"));
        data.setRemarks("remarks");
        System.out.println("the request payload"+ ConvertToJson(data));
        requestBody = data;

    }

    public static void GivenIHaveAValidPayloadToGetActivePastAppointment(Function<AppointmentStatusEnum, ActivePastAppointmentDTO> createActivePastAppointmentRequestByAppointmentStatus, AppointmentStatusEnum statusEnum){
        ActivePastAppointmentDTO data = createActivePastAppointmentRequestByAppointmentStatus.apply(statusEnum);
        System.out.println(ConvertToJson(data));
        requestBody = data;

    }

    public static void GivenIHaveValidPayloadToFilterAppointment(Function<AppointmentStatusEnum, FilterAppointmentDTO> createFilterAppointmentRequestByAppointmentStatus, AppointmentStatusEnum statusEnum) {
        FilterAppointmentDTO data = createFilterAppointmentRequestByAppointmentStatus.apply(statusEnum);
        System.out.println(ConvertToJson(data));
        requestBody = data;
    }

    public static void GivenIHaveValidPayloadToInvalidAppointment() {
        InvalidAppointmentDTO data = createInvalidAppointmentRequest.get();
        data.setDoctorId(88);
        data.setEndTime(LocalDate.now().plusDays(21).toString() + "T19:59:59.000Z");
        data.setStartTime(LocalDate.now().minusDays(1).toString() + "T20:00:00.000Z");
        System.out.println(ConvertToJson(data));
        requestBody = data;
    }

    protected abstract T getThis();
}
