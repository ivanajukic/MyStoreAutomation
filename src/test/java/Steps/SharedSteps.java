package Steps;


import HelpClasses.HelperFunctions;
import PageObjects.MainPage;
import PageObjects.MyAccountPage;
import PageObjects.SignInPage;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SharedSteps {

    @Given("^A browser is open$")
    public void BrowserIsOpen() {
        HelperFunctions.Instance().CreateDriver();
        main = new MainPage();
        signIn = new SignInPage();
        myAccount = new MyAccountPage();
    }

    private MainPage main = null;
    private SignInPage signIn = null;
    private MyAccountPage myAccount = null;

    @Given("^My Store Sign in page is open$")
    public void myStorePageIsOpen() {
        main.GoToMyStorePage();
        main.OpenSignInPage();
        signIn.VerifyIfOpen();
    }

    @Then("^My account page is open$")
    public void myAccountPageIsOpenNewAccountIsCreated() {
        myAccount.VerifyIfOpen();
    }

    @When("^I insert existing email address$")
    public void InsertExistingEmail() {
        signIn.InsertCorrectEmailToLogin();
    }

    @And("^I insert correct password$")
    public void InsertCorrectPassword() {
        signIn.InsertCorrectPasswordToLogin();
    }

    @And("^I click login button$")
    public void ClickLoginButton() {
        signIn.ClickSignInButton();
    }

    @And("^User is logged in$")
    public void userIsLoggedIn() {
        //This feature might be the first to execute, so this is hardcoded for now, will be fixed later. Works on 13.11.2019.
        if (HelperFunctions.emailAddress.matches("")) {
            HelperFunctions.emailAddress = "test13.11.2019-15.05.50@gmail.com";
        }
        InsertExistingEmail();
        InsertCorrectPassword();
        ClickLoginButton();
    }




    @After
    public void CloseDriver(){
        HelperFunctions.Instance().CloseDriver();
    }
}
