package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.BasePageUI;
import pageUIs.HomePageUI;

public class HomePage extends BasePage{
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	public void clickToAccountMenu() {
		getElement(BasePageUI.ACCOUNT_MENU).click();
	}

	public RegisterPage clickOnRegisterLink() {
		getElement(HomePageUI.REGISTER_LINK).click();
		return PageGenerator.newRegisterPage(driver);
	}

	public LogInPage clickOnLoginLink() {
		getElement(HomePageUI.LOGIN_LINK).click();
		return PageGenerator.newLogInPage(driver);
	}

	
}
