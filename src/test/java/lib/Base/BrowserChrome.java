package lib.Base;

import junit.framework.TestCase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;


public class BrowserChrome extends TestCase
{
    protected ChromeDriver driver;

    @Override
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("disable-popup-blocking"));
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        navigateTo("https://www.amazon.com/");
    }

    @Override
    public void tearDown()
    {
        driver.close();
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

}
