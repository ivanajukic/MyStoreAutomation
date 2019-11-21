package PageObjects.OrderingItemPages;

import HelpClasses.HelperFunctions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingMethods {

    private WebDriver driver = HelperFunctions.Instance().GetDriver();

    public void VerifyIfOpen() {
        WebElement shipping = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("navigation_page")));
        Assert.assertEquals("Shipping", shipping.getText());
    }

    public void CheckIfShippingMethodSelectedAndPriceMatches() {
        Assert.assertEquals("true", driver.findElement(By.xpath("//input[starts-with(@id,'delivery_option')]")).getAttribute("checked"));
        Assert.assertEquals(HelperFunctions.shippingPrice, Double.parseDouble(driver.findElement(By.className("delivery_option_price")).getText().substring(1)), 0.0);
    }

    public void AgreeToTheTermsOfService() {
        driver.findElement(By.id("cgv")).click();
    }

    public void ProceedToCheckout() {
        //find button Proceed to checkout using it's parent, element p with class cart_navigation clearfix. First parent is found and then his child that has title we need.
        driver.findElement(By.xpath("//p[@class='cart_navigation clearfix']/button[@name='processCarrier']")).click();
    }
}
