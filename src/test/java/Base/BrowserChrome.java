package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;


public class BrowserChrome
{
    private ChromeDriver driver;

    public static String
        HAMBURGER_MENU_ICON = "css:.hm-icon",
        SECTION_ELECTRONICS = "css:.hmenu-item[data-menu-id='5']",
        SECTION_COMPUTERS_AND_ACCESSORIES = "css:.hmenu[data-menu-id='5'] .hmenu-item[href*='computers']",
        FOURTH_ITEM = "css:[data-index='3']",
        FOURTH_ITEM_LINK = FOURTH_ITEM + " .aok-relative",
        ITEM_PRICE = "id:price_inside_buybox",
        ADD_TO_CART = "id:add-to-cart-button",
        CART_LINK = "id:attach-sidesheet-view-cart-button-announce",
        CART_PRICE = "id:sc-subtotal-amount-buybox";

    // Add template for item number

    @Before
    public void initialiseTest()
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("disable-popup-blocking"));
        driver = new ChromeDriver(options);
    }

    @Test
    public void testAmazonWebPage()
    {

        driver.get("https://www.amazon.com/");
        selectSection("Electronics");
    }

    @After
    public void tearDownTest()
    {
        driver.close();
    }

    public void wait(int seconds)
    {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public WebElement waitForElementPresent(String locator, String error_message, long timeoutInSeconds)
    {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitForElementAndClick(String locator, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        if (element.isDisplayed() && element.isEnabled()) {
            element.click();
        }

        return element;
    }

    private By getLocatorByString(String locator_with_type)
    {
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"), 2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];

        if (by_type.equals("xpath")) {
            return By.xpath(locator);
        } else if (by_type.equals("id")) {
            return By.id(locator);
        }  else if (by_type.equals("css")) {
            return By.cssSelector(locator);
        } else {
            throw new IllegalArgumentException("Cannot get type of locator. Locator: " + locator_with_type);
        }
    }
    public void selectSection(String section)
    {
        if (section.equals("Electronics")) {
            waitForElementAndClick(SECTION_ELECTRONICS, "Cannot find and click " + section, 5);
        } else {
            System.out.println("Section is not identified");
        }
    }

}
