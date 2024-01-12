package co.com.saucedemo.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class SaucedemoHomePage extends PageObject {

	public static final Target CONTAINER = Target.the("container").located(By.id("inventory_container"));
	public static final Target PRODUCT_NAME= Target.the("product name").located(By.id("inventory_item_name"));
	public static final Target PRODUCT_PRICE= Target.the("product price").located(By.id("inventory_item_price"));
	public static By ADD_CART_BTN = By.id("add-to-cart-"+PRODUCT_NAME.getName());

	@Override
	public List<WebElement> thenReturnElementList(By byListCriteria) {
		return super.thenReturnElementList(byListCriteria);
	}
}
