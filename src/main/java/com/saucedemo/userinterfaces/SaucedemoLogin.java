package com.saucedemo.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://www.saucedemo.com/")
public class SaucedemoLogin extends PageObject {
	public static final Target LOGIN_BUTTON = Target.the("Login btn").located(By.id("login-button"));
	public static final Target USER_NAME= Target.the("user name").located(By.id("user-name"));
	public static final Target PASSWORD = Target.the("password").located(By.id("password"));

}
