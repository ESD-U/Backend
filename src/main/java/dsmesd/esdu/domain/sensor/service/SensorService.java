package dsmesd.esdu.domain.sensor.service;

import dsmesd.esdu.domain.sensor.dto.response.SensorResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@Service
public class SensorService {

    private final SseEmitter emitter = new SseEmitter(-1L);

    public void sendSensorValue(double temperature, double humidity) {
        try {
            emitter.send(new SensorResponse(temperature, humidity));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SseEmitter getSensorValue() {
        return emitter;
    }

}
