package kanior.csyouth.domain.posts;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kanior.csyouth.web.posts.dto.PostsListResponseDto;
import kanior.csyouth.web.posts.dto.QPostsListResponseDto;

import javax.persistence.EntityManager;
import java.util.List;

import static kanior.csyouth.domain.posts.QPosts.posts;
import static kanior.csyouth.domain.user.QUser.user;

public class PostsRepositoryImpl implements PostsRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public PostsRepositoryImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<PostsListResponseDto> findAllDesc() {
        return queryFactory
                .select(new QPostsListResponseDto(posts.id, posts.title, user.name, posts.createdDate))
                .from(posts)
                .join(posts.user, user)
                .fetch();
    }
}
