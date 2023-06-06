package ecommerce.shop.service.certification;

import static ecommerce.shop.common.utils.certification.email.EmailConstants.TITLE_EMAIL_CHECK;

import ecommerce.shop.common.properties.AppProperties;
import ecommerce.shop.common.utils.certification.email.EmailContentTemplate;
import ecommerce.shop.dao.EmailCertificationDao;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmailCertificationService {

    private final AppProperties appProperties;
    private final EmailCertificationDao emailVerificationDao;

    public void sendEmailForEmailCheck(String email) {

        String token = UUID.randomUUID().toString();
        String content = makeEmailContent(token, email);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setFrom(appProperties.getEmailFromAddress());
        message.setSubject(TITLE_EMAIL_CHECK);
        message.setText(content);
//        mailSender.send(message);

        emailVerificationDao.createEmail(email, token);
    }

    public String makeEmailContent(String certificationNumber) {
        EmailContentTemplate content = new EmailContentTemplate();
        return content.buildCertificationContent(certificationNumber);
    }

    public String makeEmailContent(String token, String email) {
        EmailContentTemplate content = new EmailContentTemplate();
        return content.buildEmailCheckContent(token, email);
    }
}
