package com.saucedemo.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheackoutPage extends PageObject {
    public static final Target FIRST_NAME = Target.the("first name").located(By.id("first-name"));
    public static final Target LAST_NAME= Target.the("last name").located(By.id("last-name"));
    public static final Target POST_CODE= Target.the("postal code").located(By.id("postal-code"));
    public static final Target CONTINUE_BTN= Target.the("continue btn ").located(By.id("continue"));
    public static final Target CANCEL_BTN= Target.the("cancel btn ").located(By.id("cancel"));
    public static final Target PRODUCT_NAME_OVERVIEW= Target.the("product name overview").located(By.xpath("//div[contains(@class,'inventory_item_name')]"));
    public static final Target PRODUCT_PRICE_OVERVIEW= Target.the("product price overview ").located(By.className("inventory_item_price"));
    public static final Target PRODUCT_DESCRIPTION_OVERVIEW= Target.the("product description overview ").located(By.className("inventory_item_desc"));
    public static final Target ITEM_TOTAL_OVERVIEW= Target.the("item total overview").located(By.xpath("//*[contains(@class,'summary_subtotal_label')]"));
    public static final Target TAX_OVERVIEW= Target.the("tax overview ").located(By.className("summary_tax_label"));
    public static final Target TOTAL_OVERVIEW= Target.the("total overview ").located(By.xpath("//*[contains(@class,'summary_total_label')]"));
    public static final Target FINISH_BTN= Target.the("finish btn ").located(By.xpath("//button[@id='finish']"));
    public static final Target MESSAGE= Target.the("finish message ").located(By.className("complete-header"));

}
