package com.saucedemo.task;

import com.saucedemo.userinterfaces.SaucedemoLogin;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CredentialsIntroduction implements Task {
    String email;
    String password;

    public CredentialsIntroduction(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(email).into(SaucedemoLogin.USER_NAME),
                Enter.theValue(password).into(SaucedemoLogin.PASSWORD).
                        then(Click.on(SaucedemoLogin.LOGIN_BUTTON))
        );
    }

    public static CredentialsIntroduction intoThePage(String email, String password) {
        return instrumented(CredentialsIntroduction.class, email, password);
    }
}
