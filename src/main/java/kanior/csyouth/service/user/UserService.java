package kanior.csyouth.service.user;

import kanior.csyouth.domain.user.Role;
import kanior.csyouth.domain.user.User;
import kanior.csyouth.domain.user.UserRepository;
import kanior.csyouth.web.user.dto.UserInfo;
import kanior.csyouth.web.user.dto.UserSaveForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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
    public Long join(UserSaveForm form) {
        User savedUser = userRepository.save(User.builder()
                .loginId(form.getLoginId())
                .password(form.getPassword())
                .name(form.getName())
                .phoneNumber(form.getPhoneNumber())
                .role(Role.USER)
                .build());

        return savedUser.getId();
    }

    public UserInfo findOne (String loginId, String password) {
        Optional<User> userOptional = userRepository.findByLoginIdAndPassword(loginId, password);
        if (userOptional.isEmpty()) {
            return null;
        }
        return new UserInfo(userOptional.get());
    }

//    public Long findByNameAndPhoneNumber(String name, String phoneNumber) {
//        User user = userRepository.findByNameAndPhoneNumber(name, phoneNumber).orElseThrow(() ->
//                new IllegalArgumentException("해당 회원이 존재하지 않습니다. name=" + name + ", phoneNumber=" + phoneNumber));
//
//        if (user.getRole().equals(Role.USER)) {
//            return -1L;
//            }
//
//        return user.getId();
//    }

//    @Transactional
//    public void delete(Long id) {
//        User user = userRepository.findById(id).orElseThrow(() ->
//                new IllegalArgumentException("존재하지 않는 사용자입니다. id=" + id));
//
//        userRepository.delete(user);
//    }
}
