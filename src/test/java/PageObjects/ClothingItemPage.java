package PageObjects;

import HelpClasses.HelperFunctions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClothingItemPage {

    private WebDriver driver = HelperFunctions.Instance().GetDriver();

    public void VerifyIfOpen() {
        //Each item has unique product reference. For the previously clicked item, Faded Short Sleeve T-shirts, product reference is Model demo_1.
        WebElement productReference = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("product_reference")));
        Assert.assertEquals("Model demo_1", productReference.getText());
    }

    public void AddToCart() {
        driver.findElement(By.id("add_to_cart")).click();
    }

    public void VerifyIfPopUpOpen() {
        WebElement popUp = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("layer_cart")));
        Assert.assertTrue(popUp.isDisplayed());
    }

    public void ProceedToCheckout() {
        driver.findElement(By.xpath("//a[@title = 'Proceed to checkout']")).click();
    }

    public void SaveItemPrice() {
        HelperFunctions.unitPrice = Double.parseDouble(driver.findElement(By.id("our_price_display")).getText().substring(1));
    }
}
