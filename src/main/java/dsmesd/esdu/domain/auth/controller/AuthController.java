package dsmesd.esdu.domain.auth.controller;

import dsmesd.esdu.domain.auth.dto.request.LoginRequest;
import dsmesd.esdu.domain.auth.dto.request.TokenRefreshRequest;
import dsmesd.esdu.domain.auth.dto.response.LoginResponse;
import dsmesd.esdu.domain.auth.dto.response.TokenRefreshResponse;
import dsmesd.esdu.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        return authService.login(request.getId(), request.getPassword());
    }

    @PostMapping("/token-refresh")
    public TokenRefreshResponse tokenRefresh(@Valid @RequestBody TokenRefreshRequest request) {
        return authService.tokenRefresh(request.getRefreshToken());
    }

}
