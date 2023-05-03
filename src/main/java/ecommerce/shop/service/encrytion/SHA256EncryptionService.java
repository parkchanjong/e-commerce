package ecommerce.shop.service.encrytion;


import java.security.MessageDigest;
import org.springframework.stereotype.Component;

@Component
public class SHA256EncryptionService implements EncryptionService {

    public String encrypt(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] passBytes = s.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuilder sb = new StringBuilder();
            for (byte b : digested) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (Exception e) {
            return s;
        }
    }
}