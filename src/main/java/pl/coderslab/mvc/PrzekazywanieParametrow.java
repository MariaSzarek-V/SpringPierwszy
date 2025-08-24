package pl.coderslab.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@RestController
@RequestMapping("/pierwsze")
public class PrzekazywanieParametrow {

    @GetMapping("random/{max}/{min}")
    public String max(@PathVariable int max
    , @PathVariable int min) {
        int i = new Random().nextInt(max - min + 1) + min;
        return "Uzytkownik podal wartość max= " + max + " i min=" + min + " a wylosowalo " + i;
    }

    @GetMapping("/hello/{first}/{second}")
    public String hello(@PathVariable String first, @PathVariable String second) {
        return "Witaj jasnie wielmozna " + first + " " + second;
    }

    @PostMapping("/form")
    public String form(@RequestParam String paramName, @RequestParam String paramDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(paramDate, formatter);
        return "Witaj jasnie wielmozna " + paramName + " " + paramDate;
    }


}
