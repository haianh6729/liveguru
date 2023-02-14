package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPage extends BasePage{
	WebDriver driver;
	public RegisterPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	public boolean isRegisterPage() {
		return getElement(RegisterPageUI.CREATE_AN_ACCOUNT_TEXT).isDisplayed();
	}
	public void inputFirstname(String firstname) {
		getElement(RegisterPageUI.INPUT_FIELD, "firstname").clear();
		getElement(RegisterPageUI.INPUT_FIELD, "firstname").sendKeys(firstname);
	}
	public void inputMiddlename(String midname) {
		getElement(RegisterPageUI.INPUT_FIELD, "middlename").clear();
		getElement(RegisterPageUI.INPUT_FIELD, "middlename").sendKeys(midname);
	}
	
	public void inputLastname(String lastname) {
		getElement(RegisterPageUI.INPUT_FIELD, "lastname").clear();
		getElement(RegisterPageUI.INPUT_FIELD, "lastname").sendKeys(lastname);
	}
	public void inputEmail(String email) {
		getElement(RegisterPageUI.INPUT_FIELD, "email_address").clear();
		getElement(RegisterPageUI.INPUT_FIELD, "email_address").sendKeys(email);
	}
	public void inputPassword(String password) {
		getElement(RegisterPageUI.INPUT_FIELD, "password").clear();
		getElement(RegisterPageUI.INPUT_FIELD, "password").sendKeys(password);
	}
	public void inputConfirmPassword(String confPassword) {
		getElement(RegisterPageUI.INPUT_FIELD, "confirmation").clear();
		getElement(RegisterPageUI.INPUT_FIELD, "confirmation").sendKeys(confPassword);
	}
	public MyAccountPage clickOnRegisterButton() {
		getElement(RegisterPageUI.REGISTER_BUTTON).click();
		return PageGenerator.newMyAccountPage(driver);
	}
	
}
