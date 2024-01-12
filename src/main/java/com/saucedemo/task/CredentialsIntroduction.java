package com.saucedemo.task;

import com.saucedemo.userinterfaces.SaucedemoLogin;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Login implements Task {
    String email;
    String password;

    public Login(String email, String password){
        this.email = email;
        this.password = password;
    }
    public static Login intoThePage(String email, String password) {
        return instrumented(Login.class, email, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(email).into(SaucedemoLogin.USER_NAME),
                Enter.theValue(password).into(SaucedemoLogin.PASSWORD).
                        then(Click.on(SaucedemoLogin.LOGIN_BUTTON))
        );
    }
}
