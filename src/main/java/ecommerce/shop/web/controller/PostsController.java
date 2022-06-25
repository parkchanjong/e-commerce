package ecommerce.shop.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostsController {

    @GetMapping
    public String list() {
        return "posts/list";
    }

    @GetMapping("/save")
    public String save() {
        return "posts/save";
    }

    @GetMapping("/update")
    public String postsUpdate() {
        return "posts/update";
    }
}
