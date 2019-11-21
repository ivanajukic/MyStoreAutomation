package PageObjects;

import HelpClasses.HelperFunctions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPage {

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
        Assert.assertEquals("CREATE AN ACCOUNT", pageHeading.getText());
    }

    public void FillOutAllInformation () {
        driver.findElement(By.id("id_gender2")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("Christina");
        driver.findElement(By.id("customer_lastname")).sendKeys("Smith");
        driver.findElement(By.id("email")).click(); driver.findElement(By.id("passwd")).click();
        Assert.assertNotEquals("", driver.findElement(By.id("email")).getAttribute("value"));
        driver.findElement(By.id("passwd")).sendKeys("Test1234!");

        //Set birthday from dropdowns - 23 August 1983
        Select day = new Select(driver.findElement(By.id("days")));
        day.selectByValue("23");
        Select month = new Select(driver.findElement(By.id("months")));
        month.selectByValue("8");
        Select year = new Select(driver.findElement(By.id("years")));
        year.selectByValue("1983");

        //Sign up for newsletter and to receive special offers
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();

        //Check if automatically filled out first and last name matches your
        Assert.assertEquals("Christina", driver.findElement(By.id("firstname")).getAttribute("value"));
        Assert.assertEquals("Smith", driver.findElement(By.id("lastname")).getAttribute("value"));


        driver.findElement(By.id("company")).sendKeys("XY Company");
        driver.findElement(By.id("address1")).sendKeys("Sesame street, 56348, XY Company");
        driver.findElement(By.id("city")).sendKeys("Sesame City");

        //Select state from dropdown
        Select state = new Select(driver.findElement(By.id("id_state")));
        state.selectByVisibleText("Florida");

        driver.findElement(By.id("postcode")).sendKeys("24653");

        //Select state from dropdown
        Select country = new Select(driver.findElement(By.id("id_country")));
        country.selectByVisibleText("United States");

        driver.findElement(By.id("other")).sendKeys("Some other information about me.");
        driver.findElement(By.id("phone")).sendKeys("06254365");
        driver.findElement(By.id("phone_mobile")).sendKeys("084563521");

        //Check automatically filled out address alias
        Assert.assertNotEquals("", driver.findElement(By.id("alias")).getAttribute("value"));
    }

    public void ClickCreateButton() {
        driver.findElement(By.id("submitAccount")).click();
    }
}
