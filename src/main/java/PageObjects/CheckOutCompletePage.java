package PageObjects;

import core.BaseLocator;
import core.BasePage;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class CheckOutCompletePage extends BasePage {
    Page page;

    public CheckOutCompletePage() {
        super();
        page = new Page();
    }

    class Page {
        public BaseLocator btnBackHome() {
            return new BaseLocator(By.xpath("//button[@id='back-to-products']"));
        }

    }
    public void clickBtnBackHome() {
        page.btnBackHome().click();
    }
}
