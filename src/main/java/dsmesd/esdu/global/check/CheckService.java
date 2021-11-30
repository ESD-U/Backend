package dsmesd.esdu.global.check;

import dsmesd.esdu.global.error.exception.InvalidSecretKeyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CheckService {

    @Value("${auth.request.secret}")
    private String secretKey;

    public void checkSecretKey(String secretKey) {
        if (!this.secretKey.equals(secretKey)) {
            throw new InvalidSecretKeyException(secretKey);
        }
    }

}
