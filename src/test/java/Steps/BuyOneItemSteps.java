package Steps;

import PageObjects.ClothingItemPage;
import PageObjects.MyAccountPage;
import PageObjects.OrderHistoryPage;
import PageObjects.OrderingItemPages.AddressesPage;
import PageObjects.OrderingItemPages.PaymentPage;
import PageObjects.OrderingItemPages.ShippingMethods;
import PageObjects.OrderingItemPages.ShoppingCartPage;
import PageObjects.WomenCatalogPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BuyOneItemSteps {

    private MyAccountPage myAccount = new MyAccountPage();
    private WomenCatalogPage womenCatalog = new WomenCatalogPage();
    private ClothingItemPage clothingItem = new ClothingItemPage();
    private ShoppingCartPage shoppingCart = new ShoppingCartPage();
    private AddressesPage address = new AddressesPage();
    private ShippingMethods shippingMethods = new ShippingMethods();
    private PaymentPage payment = new PaymentPage();
    private OrderHistoryPage orderHistory = new OrderHistoryPage();

    @When("^I select category Women$")
    public void SelectCategoryWomen() {
        myAccount.VerifyIfOpen();
        myAccount.clickCategoryWomen();
    }

    @And("^I click on one item$")
    public void ClickOnOneItem() {
        womenCatalog.VerifyIfOpen();
        womenCatalog.SelectOneItem();
    }

    @And("^I add the item to cart$")
    public void AddTheItemToCart() {
        clothingItem.VerifyIfOpen();
        clothingItem.SaveItemPrice();
        clothingItem.AddToCart();
    }

    @And("^I proceed to checkout$")
    public void ProceedToCheckout() {
        clothingItem.VerifyIfPopUpOpen();
        clothingItem.ProceedToCheckout();
    }

    @And("^I verify the shopping cart summary$")
    public void VerifyTheShoppingCartSummary() {
        shoppingCart.VerifyIfOpen();
        shoppingCart.VerifyIfPriceMatches();
        shoppingCart.ProceedToCheckout();
    }

    @And("^I verify the address$")
    public void VerifyTheAddress() {
        address.VerifyIfOpen();
        address.VerifyAddressIsCorrect();
        address.ProceedToCheckout();
    }

    @And("^I select shipping method$")
    public void SelectShippingMethod() {
        shippingMethods.VerifyIfOpen();
        shippingMethods.CheckIfShippingMethodSelectedAndPriceMatches();
        shippingMethods.AgreeToTheTermsOfService();
        shippingMethods.ProceedToCheckout();
    }

    @And("^I select bank wire as payment type$")
    public void SelectBankWireAsPaymentType() {
        payment.VerifyIfOpen();
        payment.CheckIfTotalCostIsRight();
        payment.SelectBankWirePaymentType();
    }

    @And("^I confirm my order$")
    public void ConfirmMyOrder() {
        payment.VerifyPaymentTypeSelected();
        payment.ConfirmOrder();
    }

    @Then("^My order is complete$")
    public void myOrderIsComplete() {
        payment.VerifyOrderIsComplete();
        payment.VerifyAmountIsRight();
        payment.SaveOrderReference();
    }

    @And("^Bought item is visible in Order History$")
    public void boughtItemIsVisibleInOrderHistory() {
        payment.ClickBackToOrders();
        orderHistory.VerifyIfOpen();
        orderHistory.VerifyIfBoughtItemIsInList();
    }
}
