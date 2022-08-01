package kanior.csyouth.web.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {

    @NotBlank
    @Length(min = 2, max = 4)
    private String name;

    @NotBlank
    @Length(min = 10, max = 11)
    private String phoneNumber;

    @NotBlank
    @Length(min = 6, max = 16)
    private String loginId;

    @NotBlank
    @Length(min = 8, max = 16)
    private String password;

    @Builder
    public UserSaveRequestDto(String name, String phoneNumber, String loginId, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.loginId = loginId;
        this.password = password;
    }
}
