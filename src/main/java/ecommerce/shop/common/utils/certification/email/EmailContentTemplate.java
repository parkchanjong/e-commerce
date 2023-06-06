package ecommerce.shop.common.utils.certification.email;

import static ecommerce.shop.common.utils.certification.email.EmailConstants.DOMAIN_NAME;

public class EmailContentTemplate {

    public String buildCertificationContent(String certificationNumber) {

        return "인증번호는 "
                + certificationNumber
                + "입니다. ";
    }

    public String buildEmailCheckContent(String token, String email) {
        return DOMAIN_NAME
                + "/users/email-check-token?token="
                + token
                + "&email="
                + email;
    }

}
