package dsmesd.esdu.global.error.exception;

import dsmesd.esdu.global.error.ErrorCode;

public class InvalidSecretKeyException extends GlobalException {

    public InvalidSecretKeyException(String secretkey) {
        super(ErrorCode.INVALID_SECRET_KEY, secretkey + " is not correct secret key");
    }

}
