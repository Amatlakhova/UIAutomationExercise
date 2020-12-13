package lib.UI;

import org.openqa.selenium.chrome.ChromeDriver;

public class ItemsListPageObject extends MainPageObject
{
    private static final String
            ITEM = "css:[data-index='%s']",
            ITEM_LINK = ITEM + " .aok-relative";

    public ItemsListPageObject(ChromeDriver driver)
    {
        super(driver);
    }

    private static String getItemOrderNumber(String orderNumber)
    {
        return String.format(ITEM, orderNumber);
    }

    private static String getItemLinkOrderNumber(String orderNumber)
    {
        return String.format(ITEM_LINK, orderNumber);
    }

    public void findItem(String orderNumber)
    {
        this.waitForElementPresent(
                getItemOrderNumber(orderNumber),
                "Cannot select item " + orderNumber + " from the list",
                15
        );
    }

    public void openItemDetails(String orderNumber)
    {
        this.waitForElementAndClick(
                getItemLinkOrderNumber(orderNumber),
                "Cannot click on item's link",
                5
        );
    }
}
