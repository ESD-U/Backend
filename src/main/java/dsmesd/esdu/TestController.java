package dsmesd.esdu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${envrionment.test.message}")
    private String message;

    @GetMapping("/test")
    public String deployTest() {
        return "deploy success" + message;
    }

}
