package ecommerce.shop.service.user;

import ecommerce.shop.domain.user.UserRepository;
import ecommerce.shop.web.form.SignupDto;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(SignupDto signupDto) {
        return userRepository.save(signupDto.toEntity()).getId();
    }
}
