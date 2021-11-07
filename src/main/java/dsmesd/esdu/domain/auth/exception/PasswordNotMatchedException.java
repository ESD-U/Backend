package dsmesd.esdu.domain.auth.exception;

import dsmesd.esdu.global.error.ErrorCode;
import dsmesd.esdu.global.error.exception.GlobalException;

public class PasswordNotMatchedException extends GlobalException {

    public PasswordNotMatchedException() {
        super(ErrorCode.PASSWORD_NOT_MATCHED);
    }

}
