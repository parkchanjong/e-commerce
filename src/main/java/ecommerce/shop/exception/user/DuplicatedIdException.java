package ecommerce.shop.exception.user;

public class DuplicatedIdException extends IllegalArgumentException {

    public DuplicatedIdException(String message) {
        super(message);
    }
}
