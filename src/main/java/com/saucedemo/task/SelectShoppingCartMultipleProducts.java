package com.saucedemo.task;

import com.saucedemo.models.Product;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

import static com.saucedemo.userinterfaces.SaucedemoHomePage.SHOPPING_CART;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectShoppingCartMultipleProducts implements Task {
    List<Product> ListProduct;

    public SelectShoppingCartMultipleProducts(List<Product> listProduct) {
        ListProduct = listProduct;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(SHOPPING_CART)
        );
    }

    public static SelectShoppingCartMultipleProducts intoSaucedemo(List<Product> ListProduct) {
        return instrumented(SelectShoppingCartMultipleProducts.class,ListProduct);
    }
}
