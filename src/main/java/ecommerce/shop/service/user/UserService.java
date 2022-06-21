package ecommerce.shop.service.user;

import ecommerce.shop.domain.user.User;
import ecommerce.shop.domain.user.UserRepository;
import ecommerce.shop.web.dto.LoginDto;
import ecommerce.shop.web.dto.SignupDto;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void save(SignupDto signupDto) {
        validateDuplicateMember(signupDto);
        userRepository.save(signupDto.toEntity());
    }

    @Transactional(readOnly = true)
    private void validateDuplicateMember(SignupDto signupDto) {
        Optional<User> findUser = userRepository.findByEmail(signupDto.getEmail());
        if (findUser.isPresent()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    @Transactional(readOnly = true)
    public Optional<User> login(LoginDto loginDto) {
        Optional<User> findUser = userRepository.findByEmail(loginDto.getEmail());
        if (findUser.isPresent()) {
            throw new IllegalStateException("존재하지 않는 회원입니다.");
        }

        // TODO: 비밀번호 인증, 세션 설정
        return findUser;
    }
}
