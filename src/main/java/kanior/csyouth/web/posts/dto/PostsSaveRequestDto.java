package kanior.csyouth.web.posts.dto;

import kanior.csyouth.domain.posts.Posts;
import kanior.csyouth.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private Long userId;

    @Builder
    public PostsSaveRequestDto(String title, String content, Long userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public Posts toEntity(User user) {
        return Posts.builder()
                .title(title)
                .content(content)
                .user(user)
                .build();
    }
}
