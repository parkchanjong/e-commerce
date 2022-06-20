package ecommerce.shop.service.user;

import ecommerce.shop.domain.user.UserRepository;
import ecommerce.shop.web.dto.LoginDto;
import ecommerce.shop.web.dto.SignupDto;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void save(SignupDto signupDto) {
    }

    @Transactional
    public Long findByEmail(LoginDto loginDto) {
        // TODO: 로그인 인증 로직
        return 1L;
    }
}
