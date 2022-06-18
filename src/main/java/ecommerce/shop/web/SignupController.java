package ecommerce.shop.web;

import ecommerce.shop.service.user.UserService;
import ecommerce.shop.web.form.SignupDto;
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
@RequestMapping("/signup")
@RequiredArgsConstructor
public class SignupController {

    private final UserService userService;

    @GetMapping
    public String addForm(@ModelAttribute SignupDto signupDto) {
        return "user/signup";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute SignupDto signupDto, BindingResult result) {

        log.info("호출");
        if (result.hasErrors()) {
            return "user/signup";
        }
        userService.save(signupDto);
        return "redirect:/";
    }
}
