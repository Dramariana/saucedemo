package com.saucedemo.questions;

import com.saucedemo.models.Product;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

public class ValidationCart implements Question<Boolean> {

    private List<Product> product;
    private List<Product> productCart;

    public ValidationCart(List<Product> product, List<Product>productCart) {
        this.product = product;
        this.productCart = productCart;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean responde=false;
        for (int i = 0; i < productCart.size(); i++) {
            for (int j = 0; j < product.size(); j++) {
               responde= productCart.get(i).getName().equals(product.get(j).getName())
                        && productCart.get(i).getPrice().equals(product.get(j).getPrice())
                        && productCart.get(i).getDescription().equals(product.get(j).getDescription());
            }
        }
        return responde;
    }

    public static ValidationCart products(List<Product> product, List<Product> productCart) {
        return new ValidationCart(product, productCart);
    }
}