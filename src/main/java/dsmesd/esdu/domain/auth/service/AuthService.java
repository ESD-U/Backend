package dsmesd.esdu.domain.auth.service;

import dsmesd.esdu.domain.auth.dto.response.LoginResponse;
import dsmesd.esdu.domain.auth.dto.response.TokenRefreshResponse;
import dsmesd.esdu.domain.auth.entity.User;
import dsmesd.esdu.domain.auth.exception.PasswordNotMatchedException;
import dsmesd.esdu.domain.auth.exception.UserNotFoundException;
import dsmesd.esdu.domain.auth.repository.UserRepository;
import dsmesd.esdu.global.error.exception.InvalidTokenException;
import dsmesd.esdu.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public LoginResponse login(String id, String password) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        if (!passwordEncoder.matches(password,user.getPassword()))
            throw new PasswordNotMatchedException(password);

        String accessToken = jwtTokenProvider.generateAccessToken(user.getId());
        String refreshToken = jwtTokenProvider.generateRefreshToken(user.getId());

        return new LoginResponse(accessToken, refreshToken);
    }

    public TokenRefreshResponse tokenRefresh(String refreshToken) {
        if (!jwtTokenProvider.validateRefreshToken(refreshToken)) {
            throw new InvalidTokenException(refreshToken);
        }
        String id = jwtTokenProvider.getId(refreshToken);
        String accessToken = jwtTokenProvider.generateAccessToken(id);
        return new TokenRefreshResponse(accessToken);
    }

}
