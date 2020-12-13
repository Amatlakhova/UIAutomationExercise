package tests;

import lib.Base.BrowserChrome;
import lib.UI.CartPageObject;
import lib.UI.HamburgerMenuPageObject;
import lib.UI.ItemInfoPageObject;
import lib.UI.ItemsListPageObject;
import org.junit.Test;

public class AddItemToCartTest extends BrowserChrome
{
    @Test
    public void testAddItemToCart()
    {
        HamburgerMenuPageObject hamburgerMenuPageObject = new HamburgerMenuPageObject(driver);
        ItemsListPageObject itemsListPageObject = new ItemsListPageObject(driver);
        ItemInfoPageObject itemInfoPageObject = new ItemInfoPageObject(driver);
        CartPageObject cartPageObject = new CartPageObject(driver);

        hamburgerMenuPageObject.openHamburgerMenu();
        hamburgerMenuPageObject.selectMenuSection("Electronics");
        hamburgerMenuPageObject.selectMenuSection("Computers and Accessories");

        itemsListPageObject.findItem(3);
        itemsListPageObject.openItemDetails(3);

        itemInfoPageObject.storeItemPrice();
        itemInfoPageObject.clickAddToCart();
        itemInfoPageObject.closeSideSheetWindow();

        cartPageObject.navigateToCart();
        cartPageObject.verifyItemPriceNotChanged();
    }
}
