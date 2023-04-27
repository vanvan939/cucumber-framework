package Managers;

import PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private final WebDriver webDriver;
    private LoginPage loginPage;


    public PageObjectManager(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //Short Hand If...Else
    public LoginPage getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage(webDriver) : loginPage;
    }



}
