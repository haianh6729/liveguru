package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.MyAccountPageUI;

public class MyAccountPage extends BasePage {
	WebDriver driver;
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	public boolean isSuccessfulRegister() {
		return getElement(MyAccountPageUI.SUCCESSFUL_REGISTER_TEXT).isDisplayed();
	}
	public boolean isSuccessfulLogIn(String firstname,String middlename, String lastname) {
		return getElement(MyAccountPageUI.SUCCESSFUL_LOGIN_TEXT, firstname, middlename , lastname).isDisplayed();
	}
}
