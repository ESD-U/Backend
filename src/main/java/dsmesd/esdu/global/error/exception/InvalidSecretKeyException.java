package dsmesd.esdu.global.error.exception;

import dsmesd.esdu.global.error.ErrorCode;

public class InvalidSecretKeyException extends GlobalException {

    public InvalidSecretKeyException() {
        super(ErrorCode.INVALID_SECRET_KEY);
    }

}
