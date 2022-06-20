package ecommerce.shop.web.dto;

import ecommerce.shop.domain.user.User;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SignupDto {

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    public User toEntity() {
        return User.builder().email(email).password(password).build();
    }
}
