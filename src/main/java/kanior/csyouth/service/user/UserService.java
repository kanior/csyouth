package kanior.csyouth.service.user;

import kanior.csyouth.domain.user.Role;
import kanior.csyouth.domain.user.User;
import kanior.csyouth.domain.user.UserRepository;
import kanior.csyouth.web.user.dto.LoginUserInfo;
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
        return !userRepository.findByName(name)
                .filter(m -> m.getPhoneNumber().equals(phoneNumber))
                .isEmpty();
    }

    @Transactional
    public Long join(UserSaveForm form) {
        return userRepository.save(User.builder()
                .loginId(form.getLoginId())
                .password(form.getPassword())
                .name(form.getName())
                .phoneNumber(form.getPhoneNumber())
                .role(Role.USER)
                .build()
        ).getId();

    }

    public LoginUserInfo login (String loginId, String password) {
        return userRepository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .map(LoginUserInfo::new)
                .orElse(null);
    }

}
