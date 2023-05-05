package core;

import Managers.AllDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseLocator extends By {
    private WebDriver driver = AllDriverManager.getDriver();
    private By locator;
    private WebDriverWait wait = new WebDriverWait(driver,10);
    public  BaseLocator (By locator){
        this.locator = locator;
    }
    public BaseLocator waitUntilClickable(int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return this;
    }
    public BaseLocator sendKeys(CharSequence value) {
        driver.findElement(locator).sendKeys(value);
        return this;
    }
    public BaseLocator click() {
        // Try to find element and click on it up to 3 times to prevent case page
        // refresh element
        for (int i = 0; i < 3; i++) {
            try {
                driver.findElement(locator).click();
                break;
            } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
                if (i < 2) {
                    continue;
                } else {
                    throw e;
                }
            }
        }
        return this;
    }
    public String getText() {
        return driver.findElement(locator).getText();
    }
    public List<WebElement> findElements() {
        return driver.findElements(locator);
    }
    @Override
    public List<WebElement> findElements(SearchContext context) {
        return null;
    }


}
