package kanior.csyouth.web;

import kanior.csyouth.domain.posts.Posts;
import kanior.csyouth.domain.posts.PostsRepository;
import kanior.csyouth.domain.user.Role;
import kanior.csyouth.domain.user.User;
import kanior.csyouth.domain.user.UserRepository;
import kanior.csyouth.web.dto.PostsResponseDto;
import kanior.csyouth.web.dto.PostsSaveRequestDto;
import kanior.csyouth.web.dto.PostsUpdateRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostsApiControllerTest {

    @Autowired
    private PostsRepository postsRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private int port;

    @BeforeEach
    void addTestUser() {
        userRepository.save(User.builder()
                        .name("user")
                        .password("1234")
                        .phoneNumber("010-1111-2222")
                        .role(Role.USER)
                        .build());
    }

    @AfterEach
    void cleanup() {
        postsRepository.deleteAll();
        userRepository.deleteAll();
    }

    @Test
    void Posts_등록() {
        //given
        String title = "title";
        String content = "content";
        User user = userRepository.findById(1L).get();

        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
                .title(title)
                .content(content)
                .writer(user)
                .build();

        String url = "http://localhost:" + port + "/api/posts";

        //when
        ResponseEntity<Long> responseEntity =
                restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
        assertThat(all.get(0).getWriter().getName()).isEqualTo(user.getName());
    }

    @Test
    void Posts_수정() {
        //given
        User user = userRepository.findById(1L).get();

        Posts savedPosts = postsRepository.save(Posts.builder()
                        .title("title")
                        .content("content")
                        .writer(user)
                        .build());

        Long updateId = savedPosts.getId();
        String expectedTitle = "new title";
        String expectedContent = "new content";

        PostsUpdateRequestDto requestDto = PostsUpdateRequestDto.builder()
                .title(expectedTitle)
                .content(expectedContent)
                .build();

        String url = "http://localhost:" + port + "/api/posts/" + updateId;

        HttpEntity<PostsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        //when
        ResponseEntity<Long> responseEntity =
                restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
        assertThat(all.get(0).getContent()).isEqualTo(expectedContent);
        assertThat(all.get(0).getWriter().getName()).isEqualTo(user.getName());
    }

    @Test
    void Posts_조회() {
        //given
        String title = "title";
        String content = "content";
        User user = userRepository.findById(1L).get();

        Posts savedPosts = postsRepository.save(Posts.builder()
                        .title(title)
                        .content(content)
                        .writer(user)
                        .build());

        Long id = savedPosts.getId();

        String url = "http://localhost:" + port + "/api/posts/" + id;

        //when
        ResponseEntity<PostsResponseDto> responseEntity = restTemplate.getForEntity(url, PostsResponseDto.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isNotNull();

        PostsResponseDto responseDto = responseEntity.getBody();
        assertThat(responseDto.getTitle()).isEqualTo(title);
        assertThat(responseDto.getContent()).isEqualTo(content);
        assertThat(responseDto.getWriter().getName()).isEqualTo(user.getName());
    }

    @Test
    void Posts_삭제() {
        //given
        String title = "title";
        String content = "content";
        User user = userRepository.findById(1L).get();

        Posts savedPosts = postsRepository.save(Posts.builder()
                        .title(title)
                        .content(content)
                        .writer(user)
                        .build());

        Long id = savedPosts.getId();

        String url = "http://localhost:" + port + "/api/posts/" + id;

        //when
        restTemplate.delete(url);

        //then
        List<Posts> all = postsRepository.findAll();
        assertThat(all.size()).isEqualTo(0);
    }
}