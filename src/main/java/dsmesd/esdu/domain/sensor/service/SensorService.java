package dsmesd.esdu.domain.sensor.service;

import dsmesd.esdu.domain.sensor.dto.response.SensorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SensorService {

    private final List<SseEmitter> emitter = new ArrayList<>();
    private Double temperature;
    private Double humidity;

    public void sendSensorValue(double temperature, double humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        emitter.forEach( a -> {
            try {
                a.send(new SensorResponse(temperature, humidity));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public SseEmitter getSensorValue() {
        SseEmitter newSseEmitter = new SseEmitter(-1L);
        emitter.add(newSseEmitter);
        return newSseEmitter;
    }

    public ResponseEntity<SensorResponse> getRecentSensorInfo() {
        if (temperature == null || humidity == null) {
            return new ResponseEntity<>(null, HttpStatus.valueOf(204));
        }
        return new ResponseEntity<>(new SensorResponse(temperature, humidity), HttpStatus.valueOf(200));
    }
}
