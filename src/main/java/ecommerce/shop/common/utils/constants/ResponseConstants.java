package ecommerce.shop.common.utils.constants;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseConstants {

    public static final ResponseEntity<Void> CREATED =
            ResponseEntity.status(HttpStatus.CREATED).build();
}
