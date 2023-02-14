package testcase;

import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.AccountInformationPage;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MobilePage;
import pageObjects.PageGenerator;
import pageObjects.ProductDetailPage;
import pageObjects.RegisterPage;
import resources.CookiesArchive;
import resources.TestData;
import pageObjects.MyAccountPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TC3_Verify_On_Mobile_Menu extends BaseTest {
	WebDriver driver;
	HomePage homePage;
	RegisterPage registerPage;
	MyAccountPage myAccountPage;
	LogInPage logInPage;

//	String email = "ha" + generateRandomNumber() + "@mail.com";
//	String password = "111111";
//	String firstname;
//	String lastname;

	AccountInformationPage accountInforPage;
	MobilePage mobilePage;
	String productName = "SONY XPERIA";
	ProductDetailPage productDetailPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		writeLog("Login - TC01 - Step 01: Open URL");
		driver = getBrowserDriver(browserName, url);
		homePage = PageGenerator.newHomePage(driver);
		setCookieAndReloadPage();
	}

	@Test
	public void TC01_Verify_Cost_ListPage_And_DetailPage() {
		mobilePage = homePage.clickMobileLink();
		String mPrice = mobilePage.getProductPrice(productName);
		productDetailPage = mobilePage.clickProductOnList(productName);
		String pPrice = productDetailPage.getProductPrice(productName);
		verifyEqual(mPrice, pPrice);
		
	}

	@Test(enabled = false)
	public void TC02_Verify_User_Infomation_After_Register() {
		myAccountPage.openItemInMyAccountMenu("Account Information");
		accountInforPage = PageGenerator.newAccountInforPage(driver);

	}

	@AfterClass
	public void afterClass() {
//		 closeBrowserDriver();
	}

}
