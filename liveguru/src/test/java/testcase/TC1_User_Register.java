package testcase;

import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.AccountInformationPage;
import pageObjects.HomePage;
import pageObjects.PageGenerator;
import pageObjects.RegisterPage;
import resources.TestData;
import pageObjects.MyAccountPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TC1_User_Register extends BaseTest {
	WebDriver driver;
	HomePage homePage;
	RegisterPage registerPage;
	MyAccountPage myAccountPage;
//	String firstname = "hoang";
//	String midname = "hai";
//	String lastname = "anh";
//	String email = "ha" + generateRandomNumber() + "@mail.com";
//	String password = "111111";
//	String confPassword = "111111";
	AccountInformationPage accountInforPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		writeLog("Register - TC01 - Step 01: Open URL");
		driver = getBrowserDriver(browserName, url);
		homePage = PageGenerator.newHomePage(driver);
	}

	@Test
	public void TC01_Register_To_System() {
		writeLog("Register - TC01 - Step 02: Click on ACCOUNT menu");
		homePage.clickToAccountMenu();
		writeLog("Register - TC01 - Step 03: Click on Register Link");
		registerPage = homePage.clickOnRegisterLink();
		writeLog("Register - TC01 - Check open Register page");
		verifyTrue(registerPage.isRegisterPage());

		writeLog("Register - TC01 - Step 04: Input valid information");
		registerPage.inputFirstname(TestData.firstname);
		registerPage.inputMiddlename(TestData.firstname);
		registerPage.inputLastname(TestData.lastname);
		registerPage.inputEmail(TestData.email);
		registerPage.inputPassword(TestData.password);
		registerPage.inputConfirmPassword(TestData.password);
		myAccountPage = registerPage.clickOnRegisterButton();
		verifyTrue(myAccountPage.isSuccessfulRegister());

	}

	@Test
	public void TC02_Verify_User_Infomation_After_Register() {
		myAccountPage.openItemInMyAccountMenu("Account Information");
		accountInforPage = PageGenerator.newAccountInforPage(driver);
		verifyEqual(accountInforPage.getFirstname(), TestData.firstname);
		verifyEqual(accountInforPage.getLastname(), TestData.lastname);
		verifyEqual(accountInforPage.getEmail(), TestData.password);
	}

	@AfterClass
	public void afterClass() {
		// closeBrowserDriver();
	}

}
