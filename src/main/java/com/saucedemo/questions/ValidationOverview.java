package com.saucedemo.questions;

import com.saucedemo.models.Product;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidationCart implements Question<Boolean> {

    private Product product;
    private Product productCart;

    public ValidationCart(Product product, Product productCart) {
        this.product = product;
        this.productCart = productCart;
    }



    @Override
    public Boolean answeredBy(Actor actor) {
        return productCart.getName().equals(product.getName())
                && productCart.getPrice().equals(product.getPrice())
                && productCart.getDescription().equals(product.getDescription());
    }

    public static ValidationCart product(Product product, Product productCart) {
        return new ValidationCart(product, productCart);
    }
}