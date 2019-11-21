package PageObjects;

import HelpClasses.HelperFunctions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {

    private WebDriver driver = HelperFunctions.Instance().GetDriver();

    public void VerifyIfOpen() {
        //Because each page had it's own header, wait of 3 sec is added so that new page can be fully loaded before checking.
        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        //This attempts to find and return the element within 10 seconds. If nothing is found after that time, a``TimeoutException`` is thrown.
        // By default, WebDriverWait calls the ExpectedCondition every 500 milliseconds until it returns successfully.
        // A successful return value for the ExpectedCondition function type is a Boolean value of true, or a non-null object.
        WebElement pageHeading = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("page-heading")));
        Assert.assertEquals("MY ACCOUNT", pageHeading.getText());
    }

    public void clickCategoryWomen() {
        driver.findElement(By.xpath("//a[@class = 'sf-with-ul' and @title = 'Women']")).click();
    }
}
