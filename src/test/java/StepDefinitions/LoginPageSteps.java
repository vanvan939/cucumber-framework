package StepDefinitions;

import PageObjects.LoginPage;
import Utilities.ScenarioContext;
import Utilities.TestContext;
import core.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
    LoginPage loginPage = new LoginPage();
    BasePage page = new BasePage();

    @Given("The user go to page with url {string}")
    public void theUserGoToPageWithUrl(String url) {
        loginPage.openPage(url);
    }

    @When("The user input username {string} and password {string}")
    public void theUserInputUsernameAndPassword(String userName, String password) {
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
    }

    @And("The user click on Login")
    public void theUserClickOnLogin() throws InterruptedException {
        loginPage.clickLoginButton();
    }

    @Then("Go to page with title {string}")
    public void goToPageWithTitle(String title) {
        page.verifyTitlePageAsExpectedResult(title);
    }

    @Then("Go to Page with logo {string}")
    public void goToPageWithLogo(String logo) {
        loginPage.verifyLogoPageAsExpectedResult(logo);
    }
}
