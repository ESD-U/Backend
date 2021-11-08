package dsmesd.esdu.domain.light.controller;

import dsmesd.esdu.domain.light.service.LightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequiredArgsConstructor
@RequestMapping("/light")
public class LightController {

    private final LightService lightService;

    @PostMapping("/on")
    public void lightOn() {
        lightService.light(true);
    }

    @PostMapping("/off")
    public void lightOff() {
        lightService.light(false);
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter getLightInfo() {
        return lightService.getLightInfo();
    }

}
