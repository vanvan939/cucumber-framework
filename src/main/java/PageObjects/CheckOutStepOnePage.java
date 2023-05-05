package PageObjects;

import core.BaseLocator;
import core.BasePage;
import junit.framework.Assert;
import org.openqa.selenium.By;

public class CheckOutStepOnePage  extends BasePage {
    Page page;
    public CheckOutStepOnePage(){
        super();
        page = new Page();
    }
    class Page{
        public BaseLocator txtFirstName() {
            return new BaseLocator(By.xpath("//input[@id='first-name']"));
        }
        public BaseLocator txtLastName() {
            return new BaseLocator(By.xpath("//input[@id='last-name']"));
        }
        public BaseLocator txtPostCode() {
            return new BaseLocator(By.xpath("//input[@id='postal-code']"));
        }
        public BaseLocator btnContinue() {
            return new BaseLocator(By.xpath("//input[@id='continue']"));
        }

    }

    public void clickBtnContinue() {
        page.btnContinue().click();
    }

    public void enterTxtFirstName(String firstName) {
        page.txtFirstName().sendKeys(firstName);
    }

    public void enterTxtLastName(String lastName) {
        page.txtLastName().sendKeys(lastName);
    }

    public void enterTxtPostCode(String postCode) {
        page.txtPostCode().sendKeys(postCode);
    }
}
