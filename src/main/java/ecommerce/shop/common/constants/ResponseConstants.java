package ecommerce.shop.common.constants;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseConstants {

    public static final ResponseEntity<Void> OK = ResponseEntity.ok().build();
    public static final ResponseEntity<String> DUPLICATION_EMAIL =
            new ResponseEntity<>("중복된 이메일입니다.", HttpStatus.CONFLICT);

}
