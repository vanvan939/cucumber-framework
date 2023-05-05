package PageObjects;

import core.BaseLocator;
import core.BasePage;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class CheckOutStepTwoPage extends BasePage {
    Page page;

    public CheckOutStepTwoPage() {
        super();
        page = new Page();
    }

    class Page {
        public BaseLocator btnFinish() {
            return new BaseLocator(By.xpath("//button[@id='finish']"));
        }
    }
    public void clickBtnFinish() {
        page.btnFinish().click();
    }
}
