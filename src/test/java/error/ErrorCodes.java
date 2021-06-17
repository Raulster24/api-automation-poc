package error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodes {
    BAD_REQUEST(400, "error.http.400", "Bad Request");
    private final int status;
    private final String message;
    private final String title;
}
