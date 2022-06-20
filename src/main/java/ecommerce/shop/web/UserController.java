package ecommerce.shop.web;

import ecommerce.shop.service.user.UserService;
import ecommerce.shop.web.dto.LoginDto;
import ecommerce.shop.web.dto.SignupDto;
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
    public String login(@Valid @ModelAttribute LoginDto loginDto, BindingResult result) {

        log.info("로그인");
        if (result.hasErrors()) {
            return "user/login";
        }
        userService.findByEmail(loginDto);
        return "redirect:/";
    }
}
