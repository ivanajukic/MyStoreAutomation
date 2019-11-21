package Steps;

import PageObjects.CreateAccountPage;
import PageObjects.SignInPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class CreateAccountSteps {

    private SignInPage signIn = new SignInPage();
    private CreateAccountPage createAccount = new CreateAccountPage();

    @When("^I insert correct email address$")
    public void InsertCorrectEmailAddress() {
        signIn.InsertCorrectEmailToCreateAccount();
    }

    @And("^I click the option to create an account$")
    public void ClickTheOptionToCreateAnAccount() {
        signIn.ClickCreateAccountButton();
        createAccount.VerifyIfOpen();
    }

    @And("^I insert all needed information$")
    public void InsertAllNeededInformation() {
        createAccount.FillOutAllInformation();
    }

    @And("^I click on button to create account$")
    public void ClickOnButtonToCreateAccount() {
        createAccount.ClickCreateButton();
    }

}
