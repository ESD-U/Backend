package dsmesd.esdu.domain.auth.service;

import dsmesd.esdu.domain.auth.dto.request.LoginRequest;
import dsmesd.esdu.domain.auth.dto.response.LoginResponse;
import dsmesd.esdu.domain.auth.entity.User;
import dsmesd.esdu.domain.auth.exception.PasswordNotMatchedException;
import dsmesd.esdu.domain.auth.exception.UserNotFoundException;
import dsmesd.esdu.domain.auth.repository.UserRepository;
import dsmesd.esdu.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        User user = userRepository.findById(request.getId())
                .orElseThrow(UserNotFoundException::new);

        if (!passwordEncoder.matches(request.getPassword(),user.getPassword()))
            throw new PasswordNotMatchedException();

        String accessToken = jwtTokenProvider.generateAccessToken(user.getId());
        String refreshToken = jwtTokenProvider.generateRefreshToken(user.getId());

        return new LoginResponse(accessToken, refreshToken);
    }

}
