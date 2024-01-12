package com.saucedemo.task;


import com.saucedemo.models.Product;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import static com.saucedemo.userinterfaces.CheackoutPage.*;
import static com.saucedemo.userinterfaces.ShoppingCartPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CheckoutOverview implements Task, Callable<List<Product>> {

    private Product overview;
    private Product product;
    private List<Product> listProductsCart = new ArrayList<>();

    public CheckoutOverview(Product overview) {
        this.overview = overview;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        for (int i = 0; i < PRODUCT_NAME_CART.resolveAllFor(actor).size(); i++) {
            product = new Product();
            product.setName(PRODUCT_NAME_OVERVIEW.resolveAllFor(actor).get(i).getTextContent());
            product.setPrice(PRODUCT_PRICE_OVERVIEW.resolveAllFor(actor).get(i).getTextContent().replace("$", ""));
            product.setDescription(PRODUCT_DESCRIPTION_OVERVIEW.resolveAllFor(actor).get(i).getTextContent());
            listProductsCart.add(product);
        }

        call();

        actor.attemptsTo(
                WaitUntil.the(FINISH_BTN, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(FINISH_BTN));
    }


    @Override
    public List<Product> call() {
        return listProductsCart;
    }

    public static CheckoutOverview product(Product overview) {

        return instrumented(CheckoutOverview.class, overview);
    }
}
