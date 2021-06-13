package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SampleEnums {
    ACCEPT_VERSION("v1"),
    CHANNEL_NAME("WEB");
    private final String value;
}
