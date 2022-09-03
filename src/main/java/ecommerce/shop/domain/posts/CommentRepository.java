package ecommerce.shop.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Posts, Long> {

}
