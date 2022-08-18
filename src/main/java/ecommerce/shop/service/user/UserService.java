package ecommerce.shop.service.user;

import ecommerce.shop.domain.user.User;
import ecommerce.shop.domain.user.UserRepository;
import ecommerce.shop.web.dto.user.LoginDto;
import ecommerce.shop.web.dto.user.SignupDto;
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
        validateDuplicateUser(signupDto);
        userRepository.save(signupDto.toEntity());
    }

    @Transactional(readOnly = true)
    private void validateDuplicateUser(SignupDto signupDto) {
        Optional<User> findUser = userRepository.findByEmail(signupDto.getEmail());
        if (findUser.isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
        }
    }

    @Transactional(readOnly = true)
    public Optional<User> login(LoginDto loginDto) {
        return userRepository.findByEmail(loginDto.getEmail()).filter(user -> {
            try {
                return user.getPassword()
                        .equals(user.encrypt(loginDto.getPassword() + user.getSalt()));
            } catch (Exception e) {
                throw new IllegalArgumentException("아이디 또는 비밀번호가 맞지 않습니다.");
            }
        });
    }
}
