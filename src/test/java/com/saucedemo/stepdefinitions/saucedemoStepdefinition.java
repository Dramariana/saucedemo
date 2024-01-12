package com.saucedemo.stepdefinitions;


import com.saucedemo.models.Product;
import com.saucedemo.questions.ValidationCart;
import com.saucedemo.task.*;
import com.saucedemo.userinterfaces.SaucedemoLogin;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.saucedemo.userinterfaces.CheackoutPage.MESSAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsOnlyText;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;

public class saucedemoStepdefinition {

    SaucedemoLogin saucedemoLogin;

    List<Product> ListProduct = new ArrayList<>();
    List<Product> ListProductCart = new ArrayList<>();
    Product overview = new Product();

    @Managed(uniqueSession = true)
    public WebDriver driver;
    private final Actor user = Actor.named("Mariana");

    @Before
    public void prepareStage() throws IOException {
        OnStage.setTheStage(new OnlineCast());
        user.can(BrowseTheWeb.with(driver));
        //driver.manage().window().maximize();
    }

    @Given("User enters saucedemo site")
    public void userEntersSaucedemoSite() {
        user.wasAbleTo(Open.browserOn().the(saucedemoLogin));

    }

    @Given("User login with {string} and {string}")
    public void userLoginWithAnd(String email, String password) {
        user.attemptsTo(
                CredentialsIntroduction.intoThePage(email, password)
        );

    }


    @When("user add {string} products to the shopping cart")
    public void userAddProductsToTheShoppingCart(String quantity) {
        user.attemptsTo(
                SelectProducts.intoSaucedemo(ListProduct, Integer.parseInt(quantity))
        );
    }


    @And("user verifies that products of the shopping cart is the same one that was selected")
    public void userVerifiesThatProductsOfTheShoppingCartIsTheSameOneThatWasSelected() {
        user.attemptsTo(
                SelectShoppingCart.intoSaucedemo(ListProductCart)
        );
        user.should(seeThat(ValidationCart.products(ListProduct, ListProductCart)));
    }

    @And("Complete the purchase form with information {string}, {string} and {string}")
    public void completeThePurchaseFormWithInformationAnd(String name, String lastName, String codePostal) {
        user.attemptsTo(
                Cheackout.product(name, lastName, codePostal),
                CheckoutOverview.product(overview)
        );

    }

    @Then("Verify that the purchase was successful by viewing the message {string}")
    public void verifyThatThePurchaseWasSuccessfulByViewingTheMessage(String message) {
        //String messagePagina = MESSAGE.resolveFor(user).getTextContent();
        user.should(seeThat(the(MESSAGE),
                containsOnlyText(message)));
    }


}
