package PageObjects;

import core.BaseLocator;
import core.BasePage;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static Managers.AllDriverManager.getDriver;

public class LoginPage extends BasePage {
    Page page;
    public LoginPage(){
        super();
        page = new Page();
    }
    class Page{
        public BaseLocator txtUserName() {
            return new BaseLocator(By.xpath("//input[@id = 'user-name']"));
        }
        public BaseLocator txtPassword() {
            return new BaseLocator(By.xpath("//input[@id = 'password']"));
        }
        public BaseLocator btnLogin() {
            return new BaseLocator(By.xpath("//input[@id = 'login-button']"));
        }
        public BaseLocator titlePage() {
            return new BaseLocator(By.xpath("//span[@class='title']"));
        }
        public BaseLocator loginLogo() {
            return new BaseLocator(By.xpath("//div[@class='login_logo']"));
        }

    }
    @Override
    public void openPage(String url) {
        getDriver().get(url);
    }

    public void enterUserName(String userName) {
        page.txtUserName().sendKeys(userName);
    }
    public void enterPassword(String password) {
        page.txtPassword().sendKeys(password);
    }
    public void clickLoginButton() {
        page.btnLogin().click();
    }
    public void verifyLogoPageAsExpectedResult(String title) {
        Assert.assertEquals(page.loginLogo().getText(), title);
    }
    public void verifyTitlePageAsExpectedResult(String title) {
        Assert.assertEquals(page.titlePage().getText(), title);
    }
}
