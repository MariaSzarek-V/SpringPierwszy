package pl.coderslab.mvc;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class SessionController {

    @GetMapping("/session")
    public String getSessionInfo(HttpSession session) {

        if (session.getAttribute("loginStart")== null) {
            session.setAttribute("loginStart", LocalDateTime.now());
        }
        return "Czas: " + session.getAttribute("loginStart").toString();

    }

}

