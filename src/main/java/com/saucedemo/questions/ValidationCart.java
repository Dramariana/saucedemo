package com.saucedemo.questions;

import com.saucedemo.models.Product;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class Validation implements Question<Boolean> {

    private Product product;
    private Product productCart;

    public Validation(Product product, Product productCart) {
        this.product = product;
        this.productCart = productCart;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return productCart.getName().equals(product.getName())
                && productCart.getPrice().equals(product.getPrice())
                && productCart.getDescription().equals(product.getDescription());
    }

    public static Validation product(Product product, Product productCart) {
        return new Validation(product, productCart);
    }
}