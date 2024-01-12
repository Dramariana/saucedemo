package com.saucedemo.task;

import com.saucedemo.models.Product;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.concurrent.Callable;

import static com.saucedemo.userinterfaces.SaucedemoHomePage.SHOPPING_CART;
import static com.saucedemo.userinterfaces.ShoppingCartPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectShoppingCart implements Task, Callable<Product> {

    Product productCart;

    public SelectShoppingCart(Product productCart) {
        this.productCart = productCart;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                Click.on(SHOPPING_CART)
        );

        this.productCart.setName(PRODUCT_NAME_CART.resolveFor(actor).getTextContent());
        this.productCart.setPrice(PRODUCT_PRICE_CART.resolveFor(actor).getTextContent());
        this.productCart.setDescription(PRODUCT_DESCRIPTION_CART.resolveFor(actor).getTextContent());
        call();
    }

    @Override
    public Product call() {
        return productCart;
    }
    public static SelectShoppingCart intoSaucedemo(Product productCart) {
        return instrumented(SelectShoppingCart.class, productCart);
    }
}
