package com.saucedemo.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class SaucedemoHomePage extends PageObject {


	public static final Target PRODUCT_NAME= Target.the("product name").located(By.className("inventory_item_name"));
	public static final Target PRODUCT_PRICE= Target.the("product price").located(By.className("inventory_item_price"));
	public static final Target PRODUCT_DESCRIPTION= Target.the("product description").located(By.className("inventory_item_desc"));
	public static final Target ADD_CART_BTN= Target.the("add to cart").located(By.xpath("//button[contains(@id, 'add-to-cart')]"));
	public static final Target SHOPPING_CART= Target.the("shopping cart").located(By.id("shopping_cart_container"));

}
