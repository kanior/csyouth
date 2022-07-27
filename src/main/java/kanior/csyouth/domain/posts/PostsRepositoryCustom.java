package kanior.csyouth.domain.posts;

import kanior.csyouth.web.posts.dto.PostsListResponseDto;

import java.util.List;

public interface PostsRepositoryCustom {

    List<PostsListResponseDto> findAllDesc();
}
