package kanior.csyouth.web.posts.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {

    private Long id;
    private String title;
    private String writer;
    private LocalDateTime createdDate;

    @QueryProjection
    public PostsListResponseDto(Long id, String title, String writer, LocalDateTime createdDate) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.createdDate = createdDate;
    }
}
