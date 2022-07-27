package kanior.csyouth.domain.reply;

import kanior.csyouth.domain.BaseTimeEntity;
import kanior.csyouth.domain.posts.Posts;
import kanior.csyouth.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Reply extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posts_id")
    private Posts posts;

    public Reply(String content, User user, Posts posts) {
        this.content = content;
        this.user = user;
        this.posts = posts;
        this.posts.getReplies().add(this);
    }
}
