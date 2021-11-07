package dsmesd.esdu.domain.auth.exception;

import dsmesd.esdu.global.error.ErrorCode;
import dsmesd.esdu.global.error.exception.GlobalException;

public class UserNotFoundException extends GlobalException {

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }

}
