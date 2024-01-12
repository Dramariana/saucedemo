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

public class SelectMultipleProducts implements Task, Callable<List<Product>> {

    private Product products;
    private Random randomProduct;
    private int productToAdd;
    private int quantity;
    private List<WebElementFacade> ListProductsBtn;
    private List<WebElementFacade> ListProductsName;
    private List<WebElementFacade> ListProductsPrice;
    private List<WebElementFacade> ListProductsDescription;

    List<Product> ListProduct;

    public SelectMultipleProducts(List<Product> listProduct, int quantity) {

        this.ListProduct = listProduct;
        this.quantity = quantity;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        randomProduct = new Random();
        ListProductsBtn = ADD_CART_BTN.resolveAllFor(actor);
        productToAdd = randomProduct.nextInt(ListProductsBtn.size());
        ListProductsName = PRODUCT_NAME.resolveAllFor(actor);
        ListProductsPrice = PRODUCT_PRICE.resolveAllFor(actor);
        ListProductsDescription = PRODUCT_DESCRIPTION.resolveAllFor(actor);
        for (int i = 0; i < quantity; i++) {
            products = new Product(ListProductsName.get(i).getText(),
                    ListProductsPrice.get(i).getText(),
                    ListProductsDescription.get(i).getText());
            ListProduct.add(products);
        }

        call();
        for (int i = 0; i < quantity; i++) {
            actor.attemptsTo(
                    Click.on(ListProductsBtn.get(i))
            );
        }
    }

    @Override
    public List<Product> call() {
        return ListProduct;
    }

    public static SelectMultipleProducts intoSaucedemo(List<Product> ListProduct, int quantity) {
        return instrumented(SelectMultipleProducts.class, ListProduct, quantity);
    }
}
