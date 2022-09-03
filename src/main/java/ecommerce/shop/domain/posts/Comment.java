package ecommerce.shop.domain.posts;

import ecommerce.shop.domain.BaseTimeEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Table(name = "COMMENT")
@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID")
    private Long id;

    @Column(name = "GROUP_ID")
    private int groupId;

    @Column(name = "GROUP_ORDER")
    private int groupOrder;

    @Column(name = "DEPTH")
    private int depth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POSTS_ID")
    private Posts posts;

    @Column(columnDefinition = "TEXT", nullable = false, name = "CONTENT")
    private String content;

    @Column(columnDefinition = "TEXT", nullable = false, name = "AUTHOR")
    private String author;
}
