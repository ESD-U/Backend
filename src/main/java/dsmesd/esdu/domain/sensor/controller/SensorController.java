package dsmesd.esdu.domain.sensor.controller;

import dsmesd.esdu.domain.sensor.dto.request.SensorRequest;
import dsmesd.esdu.domain.sensor.dto.response.SensorResponse;
import dsmesd.esdu.domain.sensor.service.SensorService;
import dsmesd.esdu.global.check.CheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/value")
public class SensorController {

    private final SensorService sensorService;
    private final CheckService checkService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void sendSensorValue(@Valid @RequestBody SensorRequest request) {
        checkService.checkSecretKey(request.getSecretKey());
        sensorService.sendSensorValue(request.getTemperature(), request.getHumidity());
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter getSensorValue() {
        return sensorService.getSensorValue();
    }

    @GetMapping("/recent")
    public ResponseEntity<SensorResponse> getRecentSensorInfo() {
        return sensorService.getRecentSensorInfo();
    }

}
