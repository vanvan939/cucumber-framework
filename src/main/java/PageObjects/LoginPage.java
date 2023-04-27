package PageObjects;

import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {
    private final WebDriver webDriver;
    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(new AjaxElementLocatorFactory(webDriver, 15), this);
    }

    @FindBy(xpath = "//input[@id = 'user-name']")
    private WebElement txtUserName;
    @FindBy(xpath ="//input[@id = 'password']")
    private WebElement txtPassword;
    @FindBy(xpath ="//input[@id = 'login-button']")
    private WebElement btnLogin;
    @FindBy(xpath ="//span[@class='title']")
    private WebElement titlePage;

    public void navigateURL(String url) {
        webDriver.get(url);
    }

    public void enterUserName(String userName) {
        txtUserName.isDisplayed();
        txtUserName.isEnabled();
        txtUserName.sendKeys(userName);
    }
    public void enterPassword(String password) {
        txtPassword.isDisplayed();
        txtPassword.isEnabled();
        txtPassword.sendKeys(password);
    }
    public void clickLoginButton() throws InterruptedException {
        btnLogin.isDisplayed();
        btnLogin.click();
    }
    public void verifyTitlePageAsExpectedResult(String title) {
        titlePage.isDisplayed();
        Assert.assertEquals(titlePage.getText(), title);
    }


}
