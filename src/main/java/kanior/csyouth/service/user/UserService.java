package kanior.csyouth.service.user;

import kanior.csyouth.domain.user.Role;
import kanior.csyouth.domain.user.User;
import kanior.csyouth.domain.user.UserRepository;
import kanior.csyouth.web.user.dto.UserSaveForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService {

    private final UserRepository userRepository;

    public Boolean isLoginIdDuplicated(String loginId) {
        return !userRepository.findByLoginId(loginId).isEmpty();
    }

    public Boolean isNameAndPhoneNumberDuplicated(String name, String phoneNumber) {
        return !userRepository.findByNameAndPhoneNumber(name, phoneNumber).isEmpty();
    }

    @Transactional
    public Long save(UserSaveForm form) {
        User savedUser = userRepository.save(User.builder()
                .loginId(form.getLoginId())
                .password(form.getPassword())
                .name(form.getName())
                .phoneNumber(form.getPhoneNumber())
                .role(Role.USER)
                .build());

        return savedUser.getId();
    }



    public Long findByNameAndPhoneNumber(String name, String phoneNumber) {
        User user = userRepository.findByNameAndPhoneNumber(name, phoneNumber).orElseThrow(() ->
                new IllegalArgumentException("해당 회원이 존재하지 않습니다. name=" + name + ", phoneNumber=" + phoneNumber));

        if (user.getRole().equals(Role.USER)) {
            return -1L;
            }

        return user.getId();
    }

    @Transactional
    public Long signUp(Long id, String loginId, String password) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 회원이 존재하지 않습니다. id=" + id));

//        user.signUp(loginId, password);
        return id;
    }

    @Transactional
    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("존재하지 않는 사용자입니다. id=" + id));

        userRepository.delete(user);
    }
}
