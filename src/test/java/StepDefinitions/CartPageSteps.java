package StepDefinitions;

import Enums.Context;
import PageObjects.CartPage;
import Utilities.ScenarioContext;
import Utilities.TestContext;
import core.BasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;


public class CartPageSteps {
    CartPage cartPage;
    BasePage page = new BasePage();
    TestContext testContext;
    private static ScenarioContext scenarioContext = new ScenarioContext();

    public CartPageSteps(TestContext context) {
        testContext = context;
        cartPage = testContext.getPageObjectManager().getCartPage();
    }
    @And("The cart has correct 2 selected items")
    public void theCartHasCorrectSelectedItems() {
        String product1 = (String) testContext.scenarioContext.getContext(Context.PRODUCT_NAME_1);
        String product2 = (String)  testContext.scenarioContext.getContext(Context.PRODUCT_NAME_2);
        cartPage.verifyItemsInCartAreCorrect(product1,product2);
    }

    @When("The user click on Check out")
    public void theUserClickOnCheckOut() {
        cartPage.clickBtnCheckout();
    }


}
