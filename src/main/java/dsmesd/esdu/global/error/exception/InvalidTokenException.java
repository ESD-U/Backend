package dsmesd.esdu.global.error.exception;

import dsmesd.esdu.global.error.ErrorCode;

public class InvalidTokenException extends GlobalException {

    public InvalidTokenException(String token) {
        super(ErrorCode.INVALID_TOKEN, token + " is not correct token");
    }

}
