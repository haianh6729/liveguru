package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import common.BasePageUI;
import pageUIs.MobilePageUI;

public class MobilePage extends BasePage {
	WebDriver driver;

	public MobilePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public ProductDetailPage clickProductOnList(String productName) {
		productName = toCapitalize(productName);
		getElement(MobilePageUI.PRODUCT_LINK, productName).click();
		return PageGenerator.newProductDetailPage(driver);
	}
	
	public String getProductPrice(String productName) {
		productName = toCapitalize(productName);
		return getElement(MobilePageUI.LIST_ON_PRODUCT_PRICE, productName).getText();
	}
}
