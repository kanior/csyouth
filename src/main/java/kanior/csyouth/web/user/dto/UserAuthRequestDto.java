package kanior.csyouth.web.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class UserAuthRequestDto {

    @NotBlank
    @Length(min = 2, max = 4)
    private String name;

    @NotBlank
    @Length(min = 10, max = 11)
    private String phoneNumber;

    @Builder
    public UserAuthRequestDto(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
