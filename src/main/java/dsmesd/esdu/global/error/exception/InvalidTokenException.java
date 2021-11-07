package dsmesd.esdu.global.error.exception;

import dsmesd.esdu.global.error.ErrorCode;

public class InvalidTokenException extends GlobalException {

    public InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }

}
