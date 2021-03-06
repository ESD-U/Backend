package dsmesd.esdu.domain.auth.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class TokenRefreshRequest {

    @NotBlank(message = "refresh_token is missing")
    private String refreshToken;

}
