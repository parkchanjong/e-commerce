package ecommerce.shop.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/basic")
@RequiredArgsConstructor
public class BasicController {

    @GetMapping("/hellow")
    public String addForm() {
        return "content";
    }

    @GetMapping("/hellow2")
    public String addForm2() {
        return "content2";
    }

}