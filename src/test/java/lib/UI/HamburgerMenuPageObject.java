package lib.UI;

import org.openqa.selenium.chrome.ChromeDriver;

public class HamburgerMenuPageObject extends MainPageObject
{
    private static final String
            HAMBURGER_MENU_ICON = "css:.hm-icon",
            SECTION_ELECTRONICS = "css:.hmenu-item[data-menu-id='5']",
            SECTION_COMPUTERS_AND_ACCESSORIES = "css:.hmenu[data-menu-id='5'] .hmenu-item[href*='computers']";

    public HamburgerMenuPageObject(ChromeDriver driver)
    {
        super(driver);
    }

    public void openHamburgerMenu()
    {
        this.waitForElementAndClick(
                HAMBURGER_MENU_ICON,
                "Cannot find Mamburger menu icon",
                5
        );
    }

    public void selectSection(String section)
    {
        if (section.equals("Electronics")) {
            this.waitForElementAndClick(
                    SECTION_ELECTRONICS,
                    "Cannot find and click " + section,
                    5
            );
        } else if (section.equals("Computers and Accessories")) {
            this.waitForElementAndClick(
                    SECTION_COMPUTERS_AND_ACCESSORIES,
                    "Cannot find and click " + section,
                    5
            );
        }
    }

}
