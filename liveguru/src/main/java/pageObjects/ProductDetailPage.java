package pageObjects;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.MobilePageUI;
import pageUIs.ProductDetailPageUI;


public class ProductDetailPage extends BasePage{
	WebDriver driver;
	
	public ProductDetailPage(WebDriver driver) {
		super(driver);
		this.driver =driver;
	}
	
	public boolean isProductDetail(String productName) {
		toCapitalize(productName);
		return getElement(ProductDetailPageUI.PRODUCT_NAME_TEXT, productName).isDisplayed();
	}
	
	public String getProductPrice(String productName) {
		productName = toCapitalize(productName);
		return getElement(ProductDetailPageUI.PRODUCT_PRICE_TEXT, productName).getText();
	}
}
