package ecommerce.shop.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class BasicController {

    @GetMapping("/hellow")
    public String addForm() {
        return "login";
    }

    @GetMapping("/content")
    public String addForm2() {
        return "content";
    }
}