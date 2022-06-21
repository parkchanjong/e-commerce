package ecommerce.shop.web.dto;

import ecommerce.shop.domain.user.User;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDto {

    @NotBlank(message = "이메일 주소를 입력해주세요.")
    @Email(message = "이메일 주소를 입력해주세요.")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;

    public User toEntity() {
        return User.builder().email(email).password(password).build();
    }
}
