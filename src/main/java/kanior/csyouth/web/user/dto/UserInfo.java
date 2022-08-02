package kanior.csyouth.web.user.dto;

import kanior.csyouth.domain.user.Role;
import kanior.csyouth.domain.user.User;
import lombok.Getter;

@Getter
public class UserInfo {

    private Long id;

    private String name;

    private Role role;

    public UserInfo(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.role = user.getRole();
    }
}
