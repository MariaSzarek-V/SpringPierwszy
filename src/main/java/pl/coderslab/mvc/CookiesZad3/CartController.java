//package pl.coderslab.mvc.CookiesZad3;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Random;
//
//@RestController
//public class CartController {
//
//    private final Cart cart;
//    private final ProduktDao produktDao;
//
//    public CartController(Cart cart, ProduktDao produktDao) {
//        this.cart = cart;
//        this.produktDao = produktDao;
//    }
//
//
//    @RequestMapping("/addtocart")
//    @ResponseBody
//    public String addtocart(@RequestParam(name = "id") Long id,
//                            @RequestParam("quantity") Integer quantity) {
//        Product byId = produktDao.findById(id);
//        CartItem cartItem = new CartItem(quantity, byId);
//        cart.addToCart(cartItem);
//        return "addtocart";
//    }
//
//    @RequestMapping("/cart")
//    public String cart() {
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("Cart items: <br>");
//        for (CartItem item : cart.getCartItems()) {
//            stringBuilder.append("Product: ").append(item.getProduct().getName())
//                    .append(", Price: ").append(item.getProduct().getPrice())
//                    .append(", Quantity: ").append(item.getQuantity())
//                    .append("<br>");
//
//        }
//        int productElement = cart.getCartItems().size();
//        stringBuilder.append(productElement).append("<br>");
//        stringBuilder.append("W koszyku jest ");
//        stringBuilder.append(productElement).append(" pozycji.<br>");
//        int productQuantity = cart.getProductQuantity();
//
//        stringBuilder.append(productElement).append("<br>");
//        stringBuilder.append("W koszyku jest ");
//        stringBuilder.append(productQuantity).append(" produktów.<br>");
//        double totalPrice =
//                cart.getCartItems()
//                        .stream()
//                        .mapToDouble(ci->ci.getProduct().getPrice() * ci.getQuantity())
//                        .sum();
//        stringBuilder.append(productElement).append("<br>");
//        stringBuilder.append("Total price: ");
//        stringBuilder.append(totalPrice).append("<br>");
//        return stringBuilder.toString();
//    }
//
//
//
//}
