package dsmesd.esdu.domain.light.service;

import dsmesd.esdu.domain.light.dto.LightResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@Service
public class LightService {

    private final SseEmitter emitter = new SseEmitter(-1L);

    public void light(boolean light) {
        try {
            emitter.send(new LightResponse(light));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SseEmitter getLightInfo() {
        return emitter;
    }

}
