package ecommerce.shop.web;

import ecommerce.shop.domain.user.UserRepository;
import ecommerce.shop.service.user.UserService;
import ecommerce.shop.web.dto.SignupRequestDto;
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
    public String addForm() {
        return "user/signup";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute SignupRequestDto requestDto, BindingResult result) {
        if (result.hasErrors()) {
            return "user/signup";
        }
        userService.save(requestDto);
        return "redirect:/";
    }
}
