package StepDefinitions;

import PageObjects.CheckOutCompletePage;
import PageObjects.CheckOutStepOnePage;
import PageObjects.CheckOutStepTwoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;


public class CheckOutPageSteps {
    CheckOutStepOnePage checkOutStepOnePage = new CheckOutStepOnePage();
    CheckOutStepTwoPage checkOutStepTwoPage = new CheckOutStepTwoPage();
    CheckOutCompletePage checkOutCompletePage = new CheckOutCompletePage();

    @When("The user enter First Name: {string}, Last nam: {string} and Postal Code: {string}")
    public void theUserEnterFirstNameLastNamAndPostalCode(String firstName, String lastName, String postCode) {
        checkOutStepOnePage.enterTxtFirstName(firstName);
        checkOutStepOnePage.enterTxtLastName(lastName);
        checkOutStepOnePage.enterTxtPostCode(postCode);
    }

    @And("The user click on Continue")
    public void theUserClickOnContinue() {
        checkOutStepOnePage.clickBtnContinue();
    }

    @When("The user click on Finish")
    public void theUserClickOnFinish() {
        checkOutStepTwoPage.clickBtnFinish();
    }

    @When("The user click on Back Home")
    public void theUserClickOnBackHome() {
        checkOutCompletePage.clickBtnBackHome();
    }
}
