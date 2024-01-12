package com.saucedemo.questions;

import com.saucedemo.models.Overview;
import com.saucedemo.models.Product;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidationOverview implements Question<Boolean> {

    private Overview productAdd;
    private Overview overview;

    public ValidationOverview(Overview product, Overview overview) {
        this.productAdd = product;
        this.overview = overview;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return overview.getName().equals(productAdd.getName())
                && overview.getPrice().equals(productAdd.getPrice())
                && overview.getDescription().equals(productAdd.getDescription())
                && overview.getTotal().equals(String.valueOf(overview.CalculatorTotal()));
    }

    public static ValidationOverview product(Overview product, Overview overview) {
        return new ValidationOverview(product, overview);
    }
}