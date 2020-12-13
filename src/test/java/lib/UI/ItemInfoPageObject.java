package lib.UI;

import lib.Store.Store;
import org.openqa.selenium.chrome.ChromeDriver;

public class ItemInfoPageObject extends MainPageObject
{
    private static final String
            ITEM_PRICE = "id:price_inside_buybox",
            ADD_TO_CART = "id:add-to-cart-button",
            SIDESHEET_CLOSE_BTN = "id:attach-close_sideSheet-link";

    public ItemInfoPageObject(ChromeDriver driver)
    {
        super(driver);
    }

    public void storeItemPrice()
    {
        this.waitForElementPresent(
                ITEM_PRICE,
                "Cannot find price presented on the page",
                15
        );
        double price = this.getDoubleFromText(ITEM_PRICE);
        Store.mapDouble.put("ItemPrice", price);
    }

    public void clickAddToCart()
    {
        this.waitForElementAndClick(
                ADD_TO_CART,
                "Cannot find and click 'Add to cart' button",
                5
        );
    }

    public void closeSideSheetWindow()
    {
        this.waitForElementAndClick(
                SIDESHEET_CLOSE_BTN,
                "Cannot close sidesheet window",
                5
        );
    }

}
