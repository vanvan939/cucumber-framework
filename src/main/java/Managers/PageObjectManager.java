package Managers;

import PageObjects.CartPage;
import PageObjects.InventoryPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private final WebDriver webDriver;
    private InventoryPage inventoryPage;
    private CartPage cartPage;


    public PageObjectManager(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //Short Hand If...Else
    public InventoryPage getInventorPage() {
        return (inventoryPage == null) ? inventoryPage = new InventoryPage(webDriver) : inventoryPage;
    }
    public CartPage getCartPage() {
        return (cartPage == null) ? cartPage = new CartPage(webDriver) : cartPage;
    }




}
