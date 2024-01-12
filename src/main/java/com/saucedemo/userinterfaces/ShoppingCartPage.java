package com.saucedemo.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ShoppingCartPage extends PageObject {


	public static final Target PRODUCT_NAME_CART= Target.the("product name cart").located(By.className("inventory_item_name"));
	public static final Target PRODUCT_PRICE_CART= Target.the("product price cart ").located(By.className("inventory_item_price"));
	public static final Target PRODUCT_DESCRIPTION_CART= Target.the("product description cart ").located(By.className("inventory_item_desc"));
	public static final Target CONTINUE_SHOPPING_BTN= Target.the("continue shopping btn ").located(By.id("continue-shopping"));
	public static final Target CHEACKOUT_BTN= Target.the("cheackout btn ").located(By.id("checkout"));

}
