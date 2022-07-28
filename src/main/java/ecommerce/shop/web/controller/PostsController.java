package ecommerce.shop.web.controller;

import ecommerce.shop.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostsController {

    private final PostsService postsService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "posts/list";
    }

    @GetMapping("/save")
    public String save() {
        return "posts/save";
    }

    @GetMapping("/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        return "posts/update";
    }
}
