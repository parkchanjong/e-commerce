package ecommerce.shop.service.user;

import ecommerce.shop.domain.user.UserRepository;
import ecommerce.shop.web.dto.SignupRequestDto;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(SignupRequestDto requestDto) {
        return userRepository.save(requestDto.toEntity()).getId();
    }
}
