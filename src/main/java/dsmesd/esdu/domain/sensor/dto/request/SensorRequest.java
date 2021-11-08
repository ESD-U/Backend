package dsmesd.esdu.domain.sensor.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Getter
@NoArgsConstructor
public class SensorRequest {

    @NotBlank
    private String secretKey;

    @NotNull
    @Min(value = -10)
    @Max(value = 100)
    private Double temperature;

    @NotNull
    @PositiveOrZero
    @Max(value = 100)
    private Double humidity;

}
