package lib.UI;

import lib.Store.Store;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;


public class CartPageObject extends MainPageObject
{
    private static final String
            CART_LINK = "id:nav-cart-count-container",
            CART_PRICE = "id:sc-subtotal-amount-buybox";

    public CartPageObject(ChromeDriver driver)
    {
        super(driver);
    }

    public void navigateToCart()
    {
        this.waitForElementAndClick(
                CART_LINK,
                "Cannot find and click Cart button",
                15
        );
    }

    public void verifyItemPriceNotChanged()
    {
        this.waitForElementPresent(
                CART_PRICE,
                "Cannot find price presented on the page",
                15
        );
        double currentPrice = this.getDoubleFromText(CART_PRICE);
        double storedPrice = Store.mapDouble.get("ItemPrice");

        assertEquals(currentPrice, storedPrice, 0.0);
    }
}
