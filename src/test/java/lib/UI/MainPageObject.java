package lib.UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

public class MainPageObject
{
    protected ChromeDriver driver;

    public MainPageObject(ChromeDriver driver)
    {
        this.driver = driver;
    }

    public WebElement waitForElementPresent(String locator, String errorMessage, long timeoutInSeconds)
    {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(errorMessage + "\n");
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement waitForElementAndClick(String locator, String errorMessage, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(locator, errorMessage, timeoutInSeconds);
        if (element.isDisplayed() && element.isEnabled()) {
            /* Wait 1s to stabilize click of animated elements */
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            element.click();
        }

        return element;
    }

    public double getDoubleFromText(String locator)
    {
        By by = this.getLocatorByString(locator);
        String text = driver.findElement(by).getText();

        /* Method deletes everything from string except from numbers and dot */
        return Double.parseDouble(text.replaceAll("[^0-9.]", ""));
    }

    private By getLocatorByString(String locatorWithType)
    {
        String[] explodedLocator = locatorWithType.split(Pattern.quote(":"), 2);
        String byType = explodedLocator[0];
        String locator = explodedLocator[1];

        if ("xpath".equals(byType)) {
            return By.xpath(locator);
        } else if ("id".equals(byType)) {
            return By.id(locator);
        } else if ("css".equals(byType)) {
            return By.cssSelector(locator);
        }
        throw new IllegalArgumentException("Cannot get type of locator. Locator: " + locatorWithType);
    }
}
