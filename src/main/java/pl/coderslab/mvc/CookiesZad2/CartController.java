package pl.coderslab.mvc.CookiesZad2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class CartController {

    private final Cart cart;

    public CartController(Cart cart) {
        this.cart = cart;
    }

    @RequestMapping("/addtocart")
    @ResponseBody
    public String addtocart() {
        Random rand = new Random();
        cart.addToCart(new CartItem(1, new Product("prod" + rand.nextInt(10), rand.nextDouble())));
        return "addtocart";
    }

    @GetMapping("/cart")
    @ResponseBody
    public String cart() {
        StringBuilder sb = new StringBuilder("Produkty w koszyku:<br>");
        for (CartItem item : cart.getCartItems()) {
            sb.append(item.getProduct().getName())
                    .append(" - ")
                    .append(item.getProduct().getPrice())
                    .append(" zł, ilość: ")
                    .append(item.getQuantity())
                    .append("<br>");
        }
        return sb.toString();

    }

}