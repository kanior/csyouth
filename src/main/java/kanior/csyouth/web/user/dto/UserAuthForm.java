package kanior.csyouth.web.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class UserAuthForm {

    @NotBlank
    private String name;

    @NotBlank
    @Length(min = 10, max = 11)
    private String phoneNumber;
}
