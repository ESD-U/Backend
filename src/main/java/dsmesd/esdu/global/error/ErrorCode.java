package dsmesd.esdu.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    INVALID_INPUT_VALUE(400, "Invalid Input Value"),
    INVALID_TOKEN(401, "Invalid Token");

    private final int status;
    private final String message;

}