package ecommerce.shop.domain.posts;

import ecommerce.shop.domain.BaseTimeEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Table(name = "POSTS")
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POSTS_ID")
    private Long id;

    @Column(length = 500, nullable = false, name = "TITLE")
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false, name = "CONTENT")
    private String content;

    @Column(columnDefinition = "TEXT", nullable = false, name = "AUTHOR")
    private String author;


    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}