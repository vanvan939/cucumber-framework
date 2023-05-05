package StepDefinitions;

import Enums.Context;
import PageObjects.InventoryPage;
import Utilities.ScenarioContext;
import Utilities.TestContext;
import core.BasePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.Random;


public class InventoryPageSteps {
    InventoryPage inventoryPage;
    TestContext testContext;
    private static ScenarioContext scenarioContext = new ScenarioContext();
    ArrayList<String> listProducts;
    String product1;
    String product2;
    private String getRandomProduct(){
        Random random = new Random();
        int index = random.nextInt(listProducts.size());
        return listProducts.get(index);
    }

    public InventoryPageSteps(TestContext context) {
        testContext = context;
        inventoryPage = testContext.getPageObjectManager().getInventorPage();
    }
    @When("The user click on the first random product")
    public void theUserClickOnTheFirstRandomProduct() {
        listProducts = inventoryPage.listProducts();
        product1 = getRandomProduct();
        testContext.scenarioContext.setContext(Context.PRODUCT_NAME_1,product1);
        inventoryPage.clickOnButtonOfProduct(product1);
    }

    @Then("Name of button of product 1 is changed to {string}")
    public void nameOfButtonOfProduct1IsChangedTo(String nameOfButton) {
        inventoryPage.checkNameOfButtonDisplayedAsExpected(product1,nameOfButton);
    }

    @When("The user click on the second random product")
    public void theUserClickOnTheSecondRandomProduct() {
        product2 = getRandomProduct();
        for(int i= 0; i<=10; i++){
            if(product2.equals(product1)) {
                product2 = getRandomProduct();
            }
            else break;
        }
        testContext.scenarioContext.setContext(Context.PRODUCT_NAME_2, product2);
        inventoryPage.clickOnButtonOfProduct(product2);
    }

    @Then("Name of button of product 2 is changed to {string}")
    public void nameOfButtonOfProductIsChangedTo(String nameOfButton) {
        inventoryPage.checkNameOfButtonDisplayedAsExpected(product2,nameOfButton);
    }

    @When("The user click on Cart icon")
    public void theUserClickOnCartIcon() {
        inventoryPage.clickOnCartIcon();
    }
}
