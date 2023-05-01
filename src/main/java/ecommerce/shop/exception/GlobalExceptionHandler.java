package ecommerce.shop.exception;

import static ecommerce.shop.common.constants.ResponseConstants.DUPLICATION_EMAIL;

import ecommerce.shop.exception.user.DuplicateEmailException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateEmailException.class)
    public final ResponseEntity<String> handleDuplicateEmailException(
            DuplicateEmailException exception) {
        log.debug("중복된 이메일입니다.", exception);
        return DUPLICATION_EMAIL;
    }
}
