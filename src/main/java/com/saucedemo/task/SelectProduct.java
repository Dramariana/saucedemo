package com.saucedemo.task;

import com.saucedemo.models.Product;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

import static com.saucedemo.userinterfaces.SaucedemoHomePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectProduct implements Task, Callable<Product> {

    private Product products;
    private Random randomProduct;
    private int productToAdd;
    private List<WebElementFacade> ListProductsBtn;
    private List<WebElementFacade> ListProductsName;
    private List<WebElementFacade> ListProductsPrice;
    private List<WebElementFacade> ListProductsDescription;


    public SelectProduct(Product products) {
        this.products = products;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        randomProduct = new Random();
        ListProductsBtn = ADD_CART_BTN.resolveAllFor(actor);
        productToAdd = randomProduct.nextInt(ListProductsBtn.size());
        ListProductsName = PRODUCT_NAME.resolveAllFor(actor);
        ListProductsPrice = PRODUCT_PRICE.resolveAllFor(actor);
        ListProductsDescription = PRODUCT_DESCRIPTION.resolveAllFor(actor);

        products.setName(ListProductsName.get(productToAdd).getText());
        products.setPrice(ListProductsPrice.get(productToAdd).getText().replace("$", ""));
        products.setDescription(ListProductsDescription.get(productToAdd).getText());
        call();
        actor.attemptsTo(
                Click.on(ListProductsBtn.get(productToAdd))
        );
    }

    @Override
    public Product call() {
        return products;
    }

    public static SelectProduct intoSaucedemo(Product product) {

        return instrumented(SelectProduct.class, product);
    }
}
