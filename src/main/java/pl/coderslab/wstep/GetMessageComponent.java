package pl.coderslab.wstep;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
@Component
public class GetMessageComponent {
    private static final String CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    public String getMessage() {
        // Zwraca losowy napis o długości 12 znaków
        return generateRandomString(12);
    }

    private String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int idx = RANDOM.nextInt(CHARSET.length());
            sb.append(CHARSET.charAt(idx));
        }
        return sb.toString();
    }
}