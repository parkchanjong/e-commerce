package ecommerce.shop.web.dto;

import ecommerce.shop.domain.user.User;
import javax.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignupRequestDto {

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @Builder
    public SignupRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User toEntity() {
        return User.builder().email(email).password(password).build();
    }
}
