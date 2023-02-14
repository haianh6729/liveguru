package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.LogInPageUI;

public class LogInPage extends BasePage {
	WebDriver driver;

	public LogInPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isLogInPage() {
		return getElement(LogInPageUI.LOGIN_OR_CREATE_AN_ACCOUNT_TEXT).isDisplayed();

	}

	public void inputEmail(String email) {
		getElement(LogInPageUI.EMAIL_INPUT).clear();
		getElement(LogInPageUI.EMAIL_INPUT).sendKeys(email);
	}

	public void inputPassword(String password) {
		getElement(LogInPageUI.PASSWORD_INPUT).clear();
		getElement(LogInPageUI.PASSWORD_INPUT).sendKeys(password);
	}

	public MyAccountPage clickOnLogInButton() {
		getElement(LogInPageUI.LOGIN_BUTTON).click();
		return PageGenerator.newMyAccountPage(driver);
	}

}
