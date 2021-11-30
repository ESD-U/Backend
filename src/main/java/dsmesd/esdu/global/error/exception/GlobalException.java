package dsmesd.esdu.global.error.exception;

import dsmesd.esdu.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class GlobalException extends RuntimeException {

    private final ErrorCode errorCode;
    private final String reason;

    public GlobalException (ErrorCode errorCode, String reason) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.reason = reason;
    }

}
