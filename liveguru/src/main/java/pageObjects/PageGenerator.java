package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
	
	public static HomePage newHomePage(WebDriver driver) {
		return new HomePage(driver);
	}

	public static RegisterPage newRegisterPage(WebDriver driver) {
		return new RegisterPage(driver);
	}

	public static MyAccountPage newMyAccountPage(WebDriver driver) {
		return new MyAccountPage(driver);
	}

	public static AccountInformationPage newAccountInforPage(WebDriver driver) {
		return new AccountInformationPage(driver);
	}

	public static LogInPage newLogInPage(WebDriver driver) {
		return new LogInPage(driver);
	}

	public static MobilePage newMobilePage(WebDriver driver) {
		return new MobilePage(driver);
	}

	public static ProductDetailPage newProductDetailPage(WebDriver driver) {
		return new ProductDetailPage(driver);
	}
}
