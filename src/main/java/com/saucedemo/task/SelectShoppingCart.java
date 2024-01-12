package com.saucedemo.task;

import com.saucedemo.models.Product;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.concurrent.Callable;

import static com.saucedemo.userinterfaces.SaucedemoHomePage.SHOPPING_CART;
import static com.saucedemo.userinterfaces.ShoppingCartPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectShoppingCart implements Task, Callable<List<Product>> {

    private List<Product> listProductsCart ;
    private Product product;
    public SelectShoppingCart(List<Product> listProductsCart) {
        this.listProductsCart = listProductsCart;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SHOPPING_CART)
        );
        for (int i = 0; i < PRODUCT_NAME_CART.resolveAllFor(actor).size(); i++) {
            product = new Product();
            product.setName(PRODUCT_NAME_CART.resolveAllFor(actor).get(i).getTextContent());
            product.setPrice(PRODUCT_PRICE_CART.resolveAllFor(actor).get(i).getTextContent().replace("$", ""));
            product.setDescription(PRODUCT_DESCRIPTION_CART.resolveAllFor(actor).get(i).getTextContent());
            listProductsCart.add(product);
        }
        call();

        actor.attemptsTo(
                WaitUntil.the(CHEACKOUT_BTN, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(CHEACKOUT_BTN)
        );
    }

    @Override
    public List<Product> call() {
        return listProductsCart;
    }

    public static SelectShoppingCart intoSaucedemo(List<Product> listProductsCart) {
        return instrumented(SelectShoppingCart.class,listProductsCart);
    }
}
