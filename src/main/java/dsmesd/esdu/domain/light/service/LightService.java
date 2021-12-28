package dsmesd.esdu.domain.light.service;

import dsmesd.esdu.domain.light.dto.LightResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LightService {

    private final List<SseEmitter> emitter = new ArrayList<>();
    private Boolean light;

    public void light(boolean light) {
        this.light = light;
        emitter.forEach( a -> {
            try {
                a.send(new LightResponse(light));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public SseEmitter getLightInfo() {
        SseEmitter newSseEmitter = new SseEmitter(-1L);
        emitter.add(newSseEmitter);
        return newSseEmitter;
    }

    public ResponseEntity<LightResponse> getRecentLightInfo() {
        if (light == null) {
            return new ResponseEntity<>(null, HttpStatus.valueOf(204));
        }
        return new ResponseEntity<>(new LightResponse(light), HttpStatus.valueOf(200));
    }
}
