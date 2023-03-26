package ecommerce.shop.web.controller;

import static ecommerce.shop.common.utils.HttpResponses.RESPONSE_OK;

import ecommerce.shop.domain.user.User;
import ecommerce.shop.service.user.SessionConst;
import ecommerce.shop.service.user.UserService;
import ecommerce.shop.web.dto.user.LoginDto;
import ecommerce.shop.web.dto.user.SignupDto;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/users/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> signup(@Valid SignupDto signupDto) {
        userService.save(signupDto);
        return RESPONSE_OK;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@Valid LoginDto loginDto,
            HttpServletRequest request) {

        userService.login(loginDto);
        Optional<User> loginMember = userService.login(loginDto);

        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        return RESPONSE_OK;
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        return RESPONSE_OK;
    }
}
