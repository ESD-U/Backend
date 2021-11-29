package dsmesd.esdu.domain.sensor.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Getter
@NoArgsConstructor
public class SensorRequest {

    @NotBlank(message = "secret_key is missing")
    private String secretKey;

    @NotNull(message = "temperature is missing")
    @Min(value = -10, message = "temperature cannot be lower than -10")
    @Max(value = 100, message = "temperature cannot be higher than 100")
    private Double temperature;

    @NotNull(message = "humidity is missing")
    @PositiveOrZero(message = "humidity cannot be lower than 0")
    @Max(value = 100, message = "humidity cannot be higher than 100")
    private Double humidity;

}
