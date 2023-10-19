package ecommerce.shop.web.controller;

import static ecommerce.shop.common.utils.constants.ResponseConstants.CREATED;

import ecommerce.shop.service.certification.EmailCertificationService;
import ecommerce.shop.service.user.UserService;
import ecommerce.shop.web.dto.UserDto;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/users/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final EmailCertificationService emailCertificationService;

    @GetMapping("/user-emails/{email}/exists")
    public ResponseEntity<Boolean> checkEmailDuplicate(@PathVariable String email) {
        return ResponseEntity.ok(userService.checkEmailDuplicate(email));
    }

    @PostMapping
    public ResponseEntity<Void> createUser(
            @Valid @RequestBody UserDto.SaveRequest requestDto) {
        userService.save(requestDto);
//        emailCertificationService.sendEmailForEmailCheck(requestDto.getEmail());
        return CREATED;
    }
}
