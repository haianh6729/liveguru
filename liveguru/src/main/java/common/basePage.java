package common;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class basePage extends baseTest {
	WebDriver driver;
	WebDriverWait wait;
	Select select;
	Alert alert;
	Actions action;
	

	public basePage(WebDriver driver) {
		this.driver = driver;
	}

	/* Wait */
	public WebElement waitForVisibleElement(String locator) {
		wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}

	public List<WebElement> waitForVisibleElements(String locator) {
		wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
	}

	public boolean waitForInvisibleElement(String locator) {
		wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
	}

	public WebElement waitForClickableElement(String locator) {
		wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}

	public WebDriver waitForFrame(String frameLocator) {
		wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	
	public Alert waitForAlert(String locator) {
		wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	/* Handle Element */
	public WebElement getElement(String locator) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver.findElement(By.xpath(locator));
	}

	public List<WebElement> getElements(String locator) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver.findElements(By.xpath(locator));
	}

	public void clickElement(String locator) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath(locator));
	}

	public void selectDefaultDropdown(String locator, String selectedItemLocator) {
		select = new Select(waitForClickableElement(locator));
		select.selectByVisibleText(selectedItemLocator);
	}

	public void selectCustomDropdown(String dropdownLocator, String itemsCommonLocator, String selectedItemLocator) {
		clickElement(dropdownLocator);
		List<WebElement> items = waitForVisibleElements(itemsCommonLocator);
		for (WebElement item : items) {
			String itemText = item.getText();
			if (itemText.equals(selectedItemLocator)) {
				item.click();
				break;
			}

		}
	}

	public String getSelectedItemInDropdown(String selectedItem) {
		return selectedItem;
	}

	public void sendKeys(String locator, String sentKey) {
		waitForVisibleElement(locator).sendKeys(sentKey);
	}

	/* Action */
	public void sendKeysByAction(String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(waitForVisibleElement(locator), key).perform();
	}
	
	public void clickByAction(String locator) {
		action = new Actions(driver);
		action.click(waitForVisibleElement(locator)).perform();
	}

	public void doubleClickByAction(String locator) {
		action = new Actions(driver);
		action.doubleClick(waitForVisibleElement(locator)).perform();
	}

	public void rightClickByAction(String locator) {
		action = new Actions(driver);
		action.contextClick(waitForVisibleElement(locator)).perform();
	}

	public void hoverElementByAction(String locator) {
		action = new Actions(driver);
		action.moveToElement(waitForVisibleElement(locator)).perform();
	}

	public void pressKeysByAction(String keyboard) {
		action = new Actions(driver);
		action.keyDown(keyboard).perform();
		action.keyUp(keyboard).perform();
	}
	
	public void dragAndDrop(String src, String des) {
		action = new Actions(driver);
		action.dragAndDrop(getElement(src), getElement(des)).perform();
	}
	
	/* Windows/Tab */
	public void newWindowTab(WindowType tabOrWindow) {
		driver.switchTo().newWindow(tabOrWindow);
	}
	
	public String switchWindowTab(String title) {
		String parentId = driver.getWindowHandle();
		Set<String> windowIds= driver.getWindowHandles();
		for (String id:windowIds) {
			driver.switchTo().window(id);
			if (driver.getTitle().equals(title)) {
				break;
			}
		}
		
		return parentId;
	}
	
	public void closeAllWindowsExceptParent(String parentId) {
		Set<String> windowIds = driver.getWindowHandles();
		for (String id:windowIds) {
			if (!id.equals(parentId)) {
				driver.switchTo().window(id).close();
			} 
			if (driver.getWindowHandles().size()==1) {
				driver.switchTo().window(parentId);
			}
		}
	}
	
	/* Verify */
	public boolean isDisplayedElement(String locator) {
		return waitForVisibleElement(locator).isDisplayed();
	}
	
	public boolean isEnabledElement(String locator) {
		return waitForVisibleElement(locator).isEnabled();
	}
	
	public boolean isSelectedElement(String locator) {
		return waitForVisibleElement(locator).isSelected();
	}
	

	
	/* Popup */
	
	ádasdasd
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
