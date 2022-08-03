package kanior.csyouth.web.user.dto;

import kanior.csyouth.domain.user.Role;
import kanior.csyouth.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class LoginUserInfo {

    private Long id;

    private String name;

    private Role role;

    public LoginUserInfo(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.role = user.getRole();
    }
}
