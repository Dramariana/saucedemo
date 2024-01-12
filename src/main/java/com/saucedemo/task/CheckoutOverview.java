package com.saucedemo.userinterfaces;

import com.saucedemo.models.Overview;
import com.saucedemo.models.Product;
import com.saucedemo.task.Cheackout;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CheckoutOverview implements Task {
    private Overview overview;

    public CheckoutOverview(Overview overview) {
        this.overview = overview;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        overview.setName(ListProductsName.get(productToAdd).getText());
        overview.setPrice(ListProductsPrice.get(productToAdd).getText());
        overview.setDescription(ListProductsDescription.get(productToAdd).getText());
    }

    public static CheckoutOverview product(Overview overview) {

        return instrumented(CheckoutOverview.class, overview);
    }
}
