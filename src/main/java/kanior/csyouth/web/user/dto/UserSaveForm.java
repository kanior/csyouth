package kanior.csyouth.web.user.dto;

import kanior.csyouth.domain.user.Role;
import kanior.csyouth.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class UserSaveForm {

    @NotBlank
    @Length(min = 6, max = 16)
    private String loginId;

    @NotBlank
    @Length(min = 8, max = 16)
    private String password;

}
