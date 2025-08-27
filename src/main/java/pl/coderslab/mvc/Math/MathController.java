package pl.coderslab.mvc.Math;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequiredArgsConstructor
@RequestMapping("/math")
@Controller
public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @ResponseBody
    @GetMapping("/add/{a}/{b}")
    public String add(@PathVariable int a, @PathVariable int b) {
        return String.valueOf(mathService.add(a, b));
    }

    @ResponseBody
    @GetMapping("/divide")
    public String divide() {
        return String.valueOf(mathService.divide(1, 2));
    }

    @ResponseBody
    @GetMapping("/substract")
    public String substract() {
        return String.valueOf(mathService.subtract(1, 2));
    }

    @ResponseBody
    @GetMapping("/multiply")
    public String multiply() {
        return String.valueOf(mathService.multiply(1, 2));
    }

}