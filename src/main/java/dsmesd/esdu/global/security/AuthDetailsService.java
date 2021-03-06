package dsmesd.esdu.global.security;

import dsmesd.esdu.domain.auth.entity.User;
import dsmesd.esdu.domain.auth.repository.UserRepository;
import dsmesd.esdu.global.security.details.AuthUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        try {
            User user = userRepository.findById(id).get();
            return new AuthUserDetails(user);
        } catch (Exception e) {
            throw new UsernameNotFoundException(id);
        }
    }

}
