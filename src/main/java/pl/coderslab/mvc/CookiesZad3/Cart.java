package pl.coderslab.mvc.CookiesZad3;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;


@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart {

    private List<CartItem> cartItems = new java.util.ArrayList<>();


    public void addToCart(CartItem cartItem) {
        for (CartItem item : cartItems) {
            if (item.getProduct().getId().equals(cartItem.getProduct().getId())) {
                item.setQuantity(item.getQuantity() + cartItem.getQuantity());
                return;
            }
        }
        cartItems.add(cartItem);
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public int getProductQuantity() {
        int productQuantity =
                cartItems
                        .stream()
                        .mapToInt(ci->ci.getQuantity())
                        .sum();
        return productQuantity;
    }
}