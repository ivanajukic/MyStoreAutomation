package PageObjects.OrderingItemPages;

import HelpClasses.HelperFunctions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage {

    private WebDriver driver = HelperFunctions.Instance().GetDriver();

    public void VerifyIfOpen() {
        WebElement shoppingCart = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("order-detail-content")));
        Assert.assertTrue(shoppingCart.isDisplayed());
    }

    public void VerifyIfPriceMatches() {
        //Check that the item unit price on the summary matches previously saved one from item page
        Assert.assertEquals(HelperFunctions.unitPrice, Double.parseDouble(driver.findElement(By.xpath("//span[starts-with(@id,'product_price_1_1')]")).getText().substring(1)), 0.0);

        //Save value of total price of item units and check that it matches the one on the summary (total price = unit price * quantity)
        HelperFunctions.totalItemPrice = HelperFunctions.unitPrice * Double.parseDouble(driver.findElement(By.xpath("//input[starts-with(@name,'quantity') and @type='text']")).getAttribute("value"));
        Assert.assertEquals(HelperFunctions.totalItemPrice, Double.parseDouble(driver.findElement(By.xpath("//span[starts-with(@id,'total_product_price_1_1')]")).getText().substring(1)), 0.0);

        //Check that the total product price matches total items price
        HelperFunctions.allProductsPrice = Double.parseDouble(driver.findElement(By.id("total_product")).getText().substring(1));
        Assert.assertEquals(HelperFunctions.totalItemPrice, HelperFunctions.allProductsPrice , 0.0);

        //Save value of the shipping price
        HelperFunctions.shippingPrice = Double.parseDouble(driver.findElement(By.id("total_shipping")).getText().substring(1));

        //Check if the sum of total product price and shipping price (total price) matches the one on the summary
        HelperFunctions.totalPrice = HelperFunctions.totalItemPrice + HelperFunctions.shippingPrice ;
        Assert.assertEquals(HelperFunctions.totalPrice, Double.parseDouble(driver.findElement(By.id("total_price")).getText().substring(1)), 0.0);
    }

    public void ProceedToCheckout() {
        //find button Proceed to checkout using it's parent, element p with class cart_navigation clearfix. First parent is found and then his child that has title we need.
        driver.findElement(By.xpath("//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']")).click();
    }
}
