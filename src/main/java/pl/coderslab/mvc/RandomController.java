package pl.coderslab.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RandomController {


    @GetMapping("/show-random")
    @ResponseBody
    public String showRandom() {

        int random = (int) (Math.random() * 100);

        return "Wylosowano liczbę: " + random;

    }
}