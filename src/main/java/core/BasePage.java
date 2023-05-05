package core;

import Managers.AllDriverManager;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;
    Page page;

    public BasePage(){
        super();
       driver = AllDriverManager.getDriver();
       this.wait = new WebDriverWait(driver,10);
       page = new Page();
    }
    public void openPage(String url) {
        driver.get(url);
    }
    public String getUrl() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS);
        return driver.getCurrentUrl();
    }
    class Page{
        public BaseLocator titlePage() {
            return new BaseLocator(By.xpath("//span[@class='title']"));
        }
    }

    public void verifyTitlePageAsExpectedResult(String title) {
        Assert.assertEquals(page.titlePage().getText(), title);
    }
}
