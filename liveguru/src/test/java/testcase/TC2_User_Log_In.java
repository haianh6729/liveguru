package testcase;

import org.testng.annotations.Test;

import common.BaseTest;
import pageObjects.AccountInformationPage;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.PageGenerator;
import pageObjects.RegisterPage;
import resources.CookiesArchive;
import resources.TestData;
import pageObjects.MyAccountPage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class TC2_User_Log_In extends BaseTest {
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

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		writeLog("Login - TC01 - Step 01: Open URL");
		driver = getBrowserDriver(browserName, url);
		homePage = PageGenerator.newHomePage(driver);
	}

	@Test
	public void TC01_LogIn_To_System() {
		writeLog("LogIn - TC01 - Step 02: Click on ACCOUNT menu");
		homePage.clickToAccountMenu();
		writeLog("LogIn - TC01 - Step 03: Click on Log in Link");
		logInPage = homePage.clickOnLoginLink();
		writeLog("LogIn - TC01 - Check open Login page");
		verifyTrue(logInPage.isLogInPage());

		writeLog("LogIn - TC01 - Step 04: Input valid information");
		logInPage.inputEmail(TestData.email);
		logInPage.inputPassword(TestData.password);
		
		myAccountPage = logInPage.clickOnLogInButton();
		verifyTrue(myAccountPage.isSuccessfulLogIn(TestData.firstname, TestData.firstname, TestData.lastname));
		
		CookiesArchive.cookie = driver.manage().getCookies();
	}

	@Test(enabled = false)
	public void TC02_Verify_User_Infomation_After_Register() {
		myAccountPage.openItemInMyAccountMenu("Account Information");
		accountInforPage = PageGenerator.newAccountInforPage(driver);
		
	}

	@AfterClass
	public void afterClass() {
		// closeBrowserDriver();
	}

}
