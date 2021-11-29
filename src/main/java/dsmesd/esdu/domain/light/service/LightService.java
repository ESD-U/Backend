package dsmesd.esdu.domain.light.service;

import dsmesd.esdu.domain.light.dto.LightResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@Service
public class LightService {

    private final SseEmitter emitter = new SseEmitter(-1L);
    private Boolean light;

    public void light(boolean light) {
        this.light = light;
        try {
            emitter.send(new LightResponse(light));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SseEmitter getLightInfo() {
        return emitter;
    }

    public ResponseEntity<LightResponse> getRecentLightInfo() {
        if (light == null) {
            return new ResponseEntity<>(null, HttpStatus.valueOf(204));
        }
        return new ResponseEntity<>(new LightResponse(light), HttpStatus.valueOf(200));
    }
}
