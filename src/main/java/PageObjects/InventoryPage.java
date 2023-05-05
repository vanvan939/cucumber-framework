package PageObjects;

import core.BaseLocator;
import core.BasePage;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class InventoryPage extends BasePage {
    Page page;

    public InventoryPage(WebDriver webDriver) {
        super();
        page = new Page();
    }

    class Page {
        public BaseLocator titlePage() {
            return new BaseLocator(By.xpath("//span[@class='title']"));
        }

        public BaseLocator itemsName() {
            return new BaseLocator(By.xpath("//div[@class='inventory_item_name']"));
        }

        public BaseLocator buttonOfProductByName(String name) {
            return new BaseLocator(By.xpath("//div[@class= 'inventory_item_name' and text()='" + name + "']/ancestor::div[@class='inventory_item_label']/following-sibling::div/button"));
        }

        public BaseLocator cartIcon() {
            return new BaseLocator(By.xpath("//a[@class='shopping_cart_link']"));
        }
    }

    public void verifyTitlePageIsProducts() {
        Assert.assertEquals(page.titlePage().getText(), "Products");
    }

    public void clickOnButtonOfProduct(String nameOfProduct) {
        page.buttonOfProductByName(nameOfProduct).click();
    }

    public void clickOnCartIcon() {
        page.cartIcon().click();
    }

    public void checkNameOfButtonDisplayedAsExpected(String nameOfProduct, String nameOfButton) {
        Assert.assertEquals(page.buttonOfProductByName(nameOfProduct).getText(), nameOfButton);
    }

    private List<WebElement> getListItems() {
        return page.itemsName().findElements();
    }

    public ArrayList<String> listProducts() {
        ArrayList<String> itemNames = new ArrayList<>();
        for (WebElement e : getListItems()) {
            itemNames.add(e.getText());
        }
        return itemNames;
    }

}
