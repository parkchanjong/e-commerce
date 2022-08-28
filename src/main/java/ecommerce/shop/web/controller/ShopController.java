package ecommerce.shop.web.controller;

import ecommerce.shop.service.posts.PostsService;
import ecommerce.shop.web.dto.posts.PostsListResponseDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {

    private final PostsService postsService;

    @GetMapping
    public String list() {
        return "shop/list";
    }
    
}
