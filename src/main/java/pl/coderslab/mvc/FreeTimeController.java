package pl.coderslab.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


//Jeśli dzień przypada na dzień roboczy, a godzina od 9 do 17, zwróć tekst Pracuje, nie dzwoń..
//Jeśli dzień przypada na dzień roboczy, a godzina poza zakresem 9-17 zwróć tekst Po Pracy.
//Aby przetestować działanie aplikacji, możesz zamiast aktualnej daty, pobrać wybraną przez siebie datę i godzinę.

@Controller
public class FreeTimeController {

    @GetMapping("/wolne")
    @ResponseBody
    public String freeTime(){

        // testy
        // Zamiast LocalDateTime.now() wpisujemy testową datę
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String testDate = "2025-08-23 19:00"; // Sobota 19:00
        //String testDate = "2025-08-24 14:00" ; //niedziela 14.00
        LocalDateTime currentDateTime = LocalDateTime.parse(testDate, formatter);


//        LocalDateTime currentDateTime = LocalDateTime.now();
        int hour = currentDateTime.getHour();

        boolean isWeekend = false;
        if (currentDateTime.getDayOfWeek() == DayOfWeek.SATURDAY){
            isWeekend = true;
        } else if (currentDateTime.getDayOfWeek() == DayOfWeek.SUNDAY){
            isWeekend = true;
        }

        if (isWeekend){
            return "wolne";
        }
        if (!isWeekend && hour> 8 && hour <17){
            return "PRACA";
        } else {
            return "po pracy";
        }


    }
}
