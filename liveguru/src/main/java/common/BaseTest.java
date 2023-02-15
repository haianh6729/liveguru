package common;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Iterator;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import resources.CookiesArchive;
import utilities.VerificationFailures;
import utilities.enumBrowser;

public class BaseTest {
	WebDriver driver;
	protected final Logger log;
	
	public BaseTest() {
		log = LogManager.getLogger(getClass());
	}
	
	public void writeLog(String logMessage) {
		log.info(logMessage);
	}
	
	public void setCookieAndReloadPage() {
		for (Cookie ck : CookiesArchive.cookie) {
			driver.manage().addCookie(ck);
		}
		
		driver.navigate().refresh();
	}
	
	/* New driver instance then open URL*/
	public WebDriver getBrowserDriver(String browserName, String url) {
		enumBrowser browser = enumBrowser.valueOf(browserName.toUpperCase());
		switch (browser) {
		case CHROME:
			driver = new ChromeDriver();
			break;
		case EDGE:
			driver = new EdgeDriver();
			break;

		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}
	
	
	/* Quit browser and kill driver */
	public void closeBrowserDriver() {
		String cmd = null;
		String driverName = driver.toString().toLowerCase();
		String osName = System.getProperty("os.name").toLowerCase();
		
		try {
			if (driverName.contains("chrome")) {
				if (osName.contains("windows")) {
					cmd = "taskkill /F /IM chrome.exe /T";
				} else {
					cmd = "pkill chromedriver";
				}
			} else if (driverName.contains("firefox")) {
				if (osName.contains("windows")) {
					cmd = "taskkill /F /IM geckodriver.exe /T";
				} else {
					cmd = "pkill geckodriver";
				}
			} else if (driverName.contains("edge")) {
				if (osName.contains("windows")) {
					cmd = "taskkill /F /IM msedge.exe";
				} else {
					cmd = "pkill msedgedriver";
				}
			}
			
			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.quit();
			}
		} catch (Exception e) {
			log.info(e.getMessage());			
		} finally {
			Process prs;
			try {
				prs = Runtime.getRuntime().exec(cmd);
				prs.waitFor();
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
		}
	}
	
	
	/* Custom Assert */
	public void verifyTrue(boolean check) {
		try {
			assertTrue(check);
			writeLog("----------PASS---------");
		} catch (Throwable e) {
			writeLog("----------FAIL----------");
			log.error("Exception : " + e.getMessage());
			
			/* Add exception to ReportNG */
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
	}
	
	public void verifyFalse(boolean check) {
		try {
			assertFalse(check);
			writeLog("----------PASS---------");
		} catch (Throwable e) {
			writeLog("----------FAIL----------");
			log.error("Exception : " + e.getMessage());
			/* Add exception to ReportNG */
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
	}
	
	public void verifyEqual(Object actual, Object expect) {
		try {
			assertEquals(actual, expect);
			writeLog("----------PASS---------");
		} catch (Throwable e) {
			writeLog("----------FAIL----------");
			log.error("Exception : " + e.getMessage());
			/* Add exception to ReportNG */
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
	}
	
	
	public int generateRandomNumber() {
		Random randNumber = new Random(System.currentTimeMillis());
		return randNumber.nextInt(999);
		
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	
	
	
	
	
}
