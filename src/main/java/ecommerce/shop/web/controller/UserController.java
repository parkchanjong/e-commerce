package ecommerce.shop.web.controller;

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
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/signup")
    public String addSignupForm(@ModelAttribute SignupDto signupDto) {
        return "user/signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid @ModelAttribute SignupDto signupDto, BindingResult result) {

        log.info("회원가입");
        if (result.hasErrors()) {
            return "user/signup";
        }
        userService.save(signupDto);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String addLoginForm(@ModelAttribute LoginDto loginDto) {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginDto loginDto, BindingResult bindingResult,
            HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "user/login";
        }
        userService.login(loginDto);
        Optional<User> loginMember = userService.login(loginDto);

        if (loginMember.isEmpty()) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
            return "user/signup";
        }
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }
}
