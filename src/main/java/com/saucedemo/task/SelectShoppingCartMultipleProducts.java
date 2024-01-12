package com.saucedemo.task;

import com.saucedemo.models.Product;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.util.List;

import static com.saucedemo.userinterfaces.SaucedemoHomePage.SHOPPING_CART;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SelectShoppingCart implements Task {
    List<Product> ListProduct;

    public SelectShoppingCart(List<Product> listProduct) {
        ListProduct = listProduct;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
      /*  for (int i = 0; i < ListProduct.size(); i++) {
            System.out.println("Producto #"+i);
            System.out.println("Nombre: "+ListProduct.get(i).getName());
            System.out.println("Precio: "+ListProduct.get(i).getPrice());
            System.out.println("Descripcion: "+ListProduct.get(i).getDescription());
        }*/

        actor.attemptsTo(
                Click.on(SHOPPING_CART)
        );
    }

    public static SelectShoppingCart intoSaucedemo(List<Product> ListProduct) {
        return instrumented(SelectShoppingCart.class,ListProduct);
    }
}
