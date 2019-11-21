package PageObjects;

import HelpClasses.HelperFunctions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WomenCatalogPage {

    private WebDriver driver = HelperFunctions.Instance().GetDriver();

    public void VerifyIfOpen() {
        WebElement pageHeading = null;
        try {
            pageHeading = (new WebDriverWait(driver, 1)).until(ExpectedConditions.presenceOfElementLocated(By.className("navigation_page")));
        }
        catch (Exception e) {
            Assert.fail("The element is not found!");
        }
        Assert.assertEquals("Women", pageHeading.getText());
    }

    public void SelectOneItem() {
        driver.findElement(By.xpath("//a[@class = 'product_img_link' and @title = 'Faded Short Sleeve T-shirts']")).click();
    }

}


