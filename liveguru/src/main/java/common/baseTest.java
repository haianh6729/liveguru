package common;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utilities.enumBrowser;

public class baseTest {
	WebDriver driver;

	public WebDriver getBrowserDriver(String browserName) {
		browserName.toUpperCase();
		enumBrowser browser = enumBrowser.valueOf(browserName);
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

		return driver;
	}

	public int generateRandomNumber() {
		Random randNumber = new Random(System.currentTimeMillis());
		return randNumber.nextInt(999);
	}
}
