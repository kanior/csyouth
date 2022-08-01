package kanior.csyouth.web.user;

import kanior.csyouth.domain.user.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserApiControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private UserRepository userRepository;

    @AfterEach
    void cleanUp() {
        userRepository.deleteAll();
    }
//
//    @Test
//    void User_등록() {
//        //given
//        String name = "user";
//        String password = "1111";
//        String phoneNumber = "010-1111-2222";
//        UserSaveRequestDto requestDto = UserSaveRequestDto.builder()
//                .name(name)
//                .password(password)
//                .phoneNumber(phoneNumber)
//                .build();
//
//        String url = "http://localhost:" + port + "/api/user";
//
//        //when
//        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);
//
//        //then
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(responseEntity.getBody()).isGreaterThan(0L);
//
//        User user = userRepository.findAll().get(0);
//        assertThat(user.getName()).isEqualTo(name);
//        assertThat(user.getPassword()).isEqualTo(password);
//        assertThat(user.getPhoneNumber()).isEqualTo(phoneNumber);
//        assertThat(user.getRole()).isEqualTo(Role.USER);
//    }
//
//    @Test
//    void User_삭제() {
//        //given
//        User user = userRepository.save(User.builder()
//                .name("user")
//                .password("1111")
//                .phoneNumber("010-1111-2222")
//                .role(Role.USER)
//                .build());
//
//        String url = "http://localhost:" + port + "/api/user/" + user.getId();
//
//        //when
//        restTemplate.delete(url);
//
//        //then
//        List<User> all = userRepository.findAll();
//        assertThat(all.size()).isEqualTo(0);
//    }

}