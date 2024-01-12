package com.saucedemo.task;

import com.saucedemo.models.Overview;
import com.saucedemo.models.Product;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.concurrent.Callable;

import static com.saucedemo.userinterfaces.CheackoutPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CheckoutOverview implements Task, Callable<Overview> {
    private Overview overview;
    private String newTax;
    private String newItemTotal;
    private String newTotal;


    public CheckoutOverview(Overview overview) {
        this.overview = overview;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        overview.setName(PRODUCT_NAME_OVERVIEW.resolveFor(actor).getTextContent());
        overview.setPrice(PRODUCT_PRICE_OVERVIEW.resolveFor(actor).getTextContent().replace("$", ""));
        overview.setDescription(PRODUCT_DESCRIPTION_OVERVIEW.resolveFor(actor).getTextContent());

        newItemTotal = ITEM_TOTAL_OVERVIEW.resolveFor(actor).getTextContent().replace(" ", "").replace("Itemtotal:$", "");
        overview.setItemTotal(newItemTotal);

        newTax = TAX_OVERVIEW.resolveFor(actor).getTextContent().replace(" ", "").replace("Tax:$", "");
        overview.setTax(newTax);

        newTotal = TOTAL_OVERVIEW.resolveFor(actor).getTextContent().replace(" ", "").replace("Total:$", "");
        overview.setTotal(newTotal);
        call();
        actor.attemptsTo(
                Click.on(FINISH_BTN)
        );
    }


    @Override
    public Overview call() {
        return overview;
    }

    public static CheckoutOverview product(Overview overview) {

        return instrumented(CheckoutOverview.class, overview);
    }
}
