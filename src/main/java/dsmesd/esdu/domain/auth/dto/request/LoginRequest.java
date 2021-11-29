package dsmesd.esdu.domain.auth.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class LoginRequest {

    @NotBlank(message = "id is missing")
    private String id;

    @NotBlank(message = "password is missing")
    private String password;

}
