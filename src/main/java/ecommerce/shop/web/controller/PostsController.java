package ecommerce.shop.web.controller;

import ecommerce.shop.service.posts.PostsService;
import ecommerce.shop.web.dto.posts.PostsListResponseDto;
import ecommerce.shop.web.dto.posts.PostsResponseDto;
import ecommerce.shop.web.dto.posts.PostsSaveRequestDto;
import ecommerce.shop.web.dto.posts.PostsUpdateRequestDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        return "posts/update";
    }

    @GetMapping("/save")
    public String postsSave() {
        return "posts/save";
    }

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @GetMapping("/api/v1/posts/list")
    public List<PostsListResponseDto> findAll() {
        return postsService.findAllDesc();
    }
}
