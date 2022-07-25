package ecommerce.shop.service.user;

import static org.assertj.core.api.Assertions.assertThat;

import ecommerce.shop.domain.user.User;
import ecommerce.shop.domain.user.UserRepository;
import ecommerce.shop.web.dto.SignupDto;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    void 정상_회원가입() {
        //given
        String email = "asdf@asdf.asdf";
        String password = "asdf";

        SignupDto signupDto = new SignupDto();
        signupDto.setEmail(email);
        signupDto.setPassword(password);

        //when
        userService.save(signupDto);

        //then
        Optional<User> user = userRepository.findByEmail(signupDto.getEmail());
        assertThat(user.filter(findUser -> findUser.getEmail().equals(signupDto.getEmail())));
    }
}