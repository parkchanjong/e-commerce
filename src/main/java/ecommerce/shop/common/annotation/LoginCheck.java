package ecommerce.shop.common.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import ecommerce.shop.domain.users.common.UserLevel;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface LoginCheck {

    UserLevel authority() default UserLevel.UNAUTH;
}