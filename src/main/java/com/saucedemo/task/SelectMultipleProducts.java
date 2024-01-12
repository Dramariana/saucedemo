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

public class SelectProduct implements Task, Callable<List<Product>> {

    Product products;
    Random randomProduct;
    int productToAdd;
    List<WebElementFacade> ListProductsBtn;
    List<WebElementFacade> ListProductsName;
    List<WebElementFacade> ListProductsPrice;
    List<WebElementFacade> ListProductsDescription;

    List<Product> ListProduct;

    public SelectProduct(List<Product> listProduct) {
        ListProduct = listProduct;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        randomProduct = new Random();
        ListProductsBtn = ADD_CART_BTN.resolveAllFor(actor);
        productToAdd = randomProduct.nextInt(ListProductsBtn.size());
        ListProductsName = PRODUCT_NAME.resolveAllFor(actor);
        ListProductsPrice = PRODUCT_PRICE.resolveAllFor(actor);
        ListProductsDescription = PRODUCT_DESCRIPTION.resolveAllFor(actor);
/*        for (int i = 0; i < ListProductsBtn.size(); i++) {
            products = new Products(ListProductsName.get(i).getText(),
                    ListProductsPrice.get(i).getText(),
                    ListProductsDescription.get(i).getText());
            ListProduct.add(products);
        }*/
        products = new Product(ListProductsName.get(productToAdd).getText(),
                ListProductsPrice.get(productToAdd).getText(),
                ListProductsDescription.get(productToAdd).getText());
        ListProduct.add(products);
        call();
        actor.attemptsTo(
                Click.on(ListProductsBtn.get(productToAdd))
        );
    }

    @Override
    public List<Product> call() {
        return ListProduct;
    }

    public static SelectProduct intoSaucedemo(List<Product> ListProduct) {
        return instrumented(SelectProduct.class, ListProduct);
    }
}
