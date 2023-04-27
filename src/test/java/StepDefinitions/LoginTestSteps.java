package StepDefinitions;

import PageObjects.LoginPage;
import Utilities.ScenarioContext;
import Utilities.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTestSteps {
    LoginPage loginPage;
    TestContext testContext;
    private static ScenarioContext scenarioContext = new ScenarioContext();

    public LoginTestSteps(TestContext context) {
        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();

    }
    @Given("The user go to page with url {string}")
    public void theUserGoToPageWithUrl(String url) {
        loginPage.navigateURL(url);
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
        loginPage.verifyTitlePageAsExpectedResult(title);
    }
}
