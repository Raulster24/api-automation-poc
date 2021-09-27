package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AppointmentStatusEnum {
    ACCEPTED, AVAILABLE, REJECTED, PENDING, CANCELLED_BY_PATIENT, CANCELLED_BY_DOCTOR, UNAVAILABLE
}
