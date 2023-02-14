package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.RegisterPageUI;

public class AccountInformationPage extends BasePage{
	WebDriver driver;
	public AccountInformationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getFirstname() {
		return getElement(RegisterPageUI.INPUT_FIELD, "firstname").getAttribute("value");
	}

	public String getLastname() {
		return getElement(RegisterPageUI.INPUT_FIELD, "lastname").getAttribute("value");
	}

	public String getEmail() {
		return getElement(RegisterPageUI.INPUT_FIELD, "email").getAttribute("value");
	}

}
