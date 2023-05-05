package PageObjects;

import core.BaseLocator;
import core.BasePage;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    Page page;

    public CartPage(WebDriver webDriver) {
        super();
        page = new Page();
    }

    class Page {
        public BaseLocator titlePage() {
            return new BaseLocator(By.xpath("//span[@class='title']"));
        }

        public BaseLocator itemName() {
            return new BaseLocator(By.xpath("//div[@class='inventory_item_name']"));
        }

        public BaseLocator btnCheckout() {
            return new BaseLocator(By.xpath("//button[@id='checkout']"));
        }

    }

    public void verifyTitlePageIsYourCart(String title) {
        Assert.assertEquals(page.titlePage().getText(), title);
    }

    private List<WebElement> getListItems() {
        return page.itemName().findElements();
    }

    public void verifyItemsInCartAreCorrect(String productName1, String productName2) {
        String[] productNames = {productName1, productName2};
        ArrayList<String> itemNames = new ArrayList<String>();
        for (WebElement e : getListItems()) {
            itemNames.add(e.getText());
        }
        for (int i = 0; i < productNames.length; i++) {
            Assert.assertEquals(itemNames.get(i), productNames[i]);
        }
    }

    public void clickBtnCheckout() {
        page.btnCheckout().click();
    }
}
