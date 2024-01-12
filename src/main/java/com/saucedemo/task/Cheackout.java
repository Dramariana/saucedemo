package com.saucedemo.task;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.saucedemo.userinterfaces.CheackoutPage.*;
import static com.saucedemo.userinterfaces.ShoppingCartPage.CHEACKOUT_BTN;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Cheackout implements Task {

    private String name;
    private String lastName;
    private String codePostal;

    public Cheackout(String name, String lastName, String codePostal) {
        this.name = name;
        this.lastName = lastName;
        this.codePostal = codePostal;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
       actor.attemptsTo(
               Click.on(FIRST_NAME),
               Enter.theValue(name).into(FIRST_NAME),
               Enter.theValue(lastName).into(LAST_NAME),
               Enter.theValue(codePostal).into(POST_CODE),
               WaitUntil.the(CONTINUE_BTN, isVisible()).forNoMoreThan(10).seconds(),
               Click.on(CONTINUE_BTN)
       );
    }

    public static Cheackout product(String name, String lastName, String codePostal) {
        return instrumented(Cheackout.class, name, lastName, codePostal);
    }
}
