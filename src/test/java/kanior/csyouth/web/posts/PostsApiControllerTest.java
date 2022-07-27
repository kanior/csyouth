package kanior.csyouth.web.posts;

import kanior.csyouth.domain.posts.Posts;
import kanior.csyouth.domain.posts.PostsRepository;
import kanior.csyouth.web.posts.dto.PostsResponseDto;
import kanior.csyouth.web.posts.dto.PostsSaveRequestDto;
import kanior.csyouth.web.posts.dto.PostsUpdateRequestDto;
import org.junit.jupiter.api.AfterEach;
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

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    void cleanup() {
        postsRepository.deleteAll();
//        userRepository.deleteAll();
    }
//
//    @Test
//    void Posts_등록() {
//        //given
//        String title = "title";
//        String content = "content";
////        User user = userRepository.findByName("user").get();
//
//        PostsSaveRequestDto requestDto = PostsSaveRequestDto.builder()
//                .title(title)
//                .content(content)
//                .writer(null)
//                .build();
//
//        String url = "http://localhost:" + port + "/api/posts";
//
//        //when
//        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);
//
//        //then
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseEntity.getBody()).isGreaterThan(0L);
//
//        Posts posts = postsRepository.findAll().get(0);
////        User writer = posts.getWriter();
//
//        assertThat(posts.getTitle()).isEqualTo(title);
//        assertThat(posts.getContent()).isEqualTo(content);
////        assertThat(writer.getName()).isEqualTo(user.getName());
//    }
//
//    @Test
//    void Posts_수정() {
//        //given
////        User user = userRepository.findById(1L).get();
//
//        Posts savedPosts = postsRepository.save(Posts.builder()
//                        .title("title")
//                        .content("content")
//                        .writer(null)
//                        .build());
//
//        Long updateId = savedPosts.getId();
//        String expectedTitle = "new title";
//        String expectedContent = "new content";
//
//        PostsUpdateRequestDto requestDto = PostsUpdateRequestDto.builder()
//                .title(expectedTitle)
//                .content(expectedContent)
//                .build();
//
//        String url = "http://localhost:" + port + "/api/posts/" + updateId;
//
//        HttpEntity<PostsUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);
//
//        //when
//        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);
//
//        //then
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseEntity.getBody()).isGreaterThan(0L);
//
//        List<Posts> all = postsRepository.findAll();
//        assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
//        assertThat(all.get(0).getContent()).isEqualTo(expectedContent);
////        assertThat(all.get(0).getWriter().getName()).isEqualTo(user.getName());
//    }
//
//    @Test
//    void Posts_조회() {
//        //given
//        String title = "title";
//        String content = "content";
////        User user = userRepository.findById(1L).get();
//
//        Posts savedPosts = postsRepository.save(Posts.builder()
//                        .title(title)
//                        .content(content)
//                        .writer(null)
//                        .build());
//
//        Long id = savedPosts.getId();
//
//        String url = "http://localhost:" + port + "/api/posts/" + id;
//
//        //when
//        ResponseEntity<PostsResponseDto> responseEntity = restTemplate.getForEntity(url, PostsResponseDto.class);
//
//        //then
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseEntity.getBody()).isNotNull();
//
//        PostsResponseDto responseDto = responseEntity.getBody();
//        assertThat(responseDto.getTitle()).isEqualTo(title);
//        assertThat(responseDto.getContent()).isEqualTo(content);
////        assertThat(responseDto.getWriter().getName()).isEqualTo(user.getName());
//    }
//
//    @Test
//    void Posts_삭제() {
//        //given
//        Posts savedPosts = postsRepository.save(Posts.builder()
//                        .title("title")
//                        .content("content")
//                        .writer(null)
//                        .build());
//
//        String url = "http://localhost:" + port + "/api/posts/" + savedPosts.getId();
//
//        //when
//        restTemplate.delete(url);
//
//        //then
//        List<Posts> all = postsRepository.findAll();
//        assertThat(all.size()).isEqualTo(0);
//    }
}