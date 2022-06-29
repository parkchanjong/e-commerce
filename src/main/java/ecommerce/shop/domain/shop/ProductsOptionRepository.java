package ecommerce.shop.domain.shop;

import ecommerce.shop.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsOptionRepository extends JpaRepository<Posts, Long> {

}
