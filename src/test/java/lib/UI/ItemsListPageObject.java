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

    private static String getItemByOrderNumber(int orderNumber)
    {
        return String.format(ITEM, orderNumber);
    }

    private static String getItemLinkByOrderNumber(int orderNumber)
    {
        return String.format(ITEM_LINK, orderNumber);
    }

    /**
     * Order number starts from 0
     * @param orderNumber
     */
    public void findItem(int orderNumber)
    {
        this.waitForElementPresent(
                getItemByOrderNumber(orderNumber),
                "Cannot select item " + orderNumber + " from the list",
                15
        );
    }

    /**
     * Order number starts from 0
     * @param orderNumber
     */
    public void openItemDetails(int orderNumber)
    {
        this.waitForElementAndClick(
                getItemLinkByOrderNumber(orderNumber),
                "Cannot click on item's link",
                5
        );
    }
}
