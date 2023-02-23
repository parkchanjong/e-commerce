package ecommerce.shop.web.controller;

import static ecommerce.shop.utils.HttpResponses.RESPONSE_BAD_REQUEST;
import static ecommerce.shop.utils.HttpResponses.RESPONSE_OK;
import static ecommerce.shop.utils.HttpResponses.RESPONSE_UNAUTHORIZED;

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
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Controller
@RequestMapping
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Void> signup(@Valid @ModelAttribute SignupDto signupDto,
            BindingResult result) {

        log.info("회원가입");
        if (result.hasErrors()) {
            return RESPONSE_BAD_REQUEST;
        }
        userService.save(signupDto);
        return RESPONSE_OK;
    }

    @GetMapping("/login")
    public String addLoginForm(@ModelAttribute LoginDto loginDto) {
        return "user/login";
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@Valid @ModelAttribute LoginDto loginDto,
            BindingResult bindingResult, HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return RESPONSE_BAD_REQUEST;
        }
        userService.login(loginDto);
        Optional<User> loginMember = userService.login(loginDto);

        if (loginMember.isEmpty()) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return RESPONSE_UNAUTHORIZED;
        }
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        return RESPONSE_OK;
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return RESPONSE_OK;
    }
}
