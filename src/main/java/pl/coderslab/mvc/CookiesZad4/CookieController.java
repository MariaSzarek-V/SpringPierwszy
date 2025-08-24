package pl.coderslab.mvc.CookiesZad4;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.WebUtils;

@RestController
public class CookieController {

    @GetMapping("/setcookie/{value1}/{value2}")
    public String setCookie(@PathVariable String value1, @PathVariable String value2
    , HttpServletResponse response){
        Cookie cookie1 = new Cookie("cookie1", value1);
        Cookie cookie2 = new Cookie("cookie2", value2);
        cookie1.setPath("/");
        cookie2.setPath("/");
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        return "setCookies";
    }
// pierwsza metoda i druga metoda polaczona

    @GetMapping("/getcookies")
    public String getCookies(HttpServletRequest request,
                             @CookieValue (value = "cookie2") String cookie2Value) {
        Cookie cookie1 = WebUtils.getCookie(request, "cookie1");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(cookie1.getName()).append("=").append(cookie1.getValue());
        stringBuilder.append(cookie2Value);

        return stringBuilder.toString();
    }
}
