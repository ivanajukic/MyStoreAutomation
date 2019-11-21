package PageObjects;

import HelpClasses.HelperFunctions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SignInPage {

    private WebDriver driver = HelperFunctions.Instance().GetDriver();

    public void VerifyIfOpen() {
        //This attempts to find and return the element within 10 seconds. If nothing is found after that time, a``TimeoutException`` is thrown.
        // By default, WebDriverWait calls the ExpectedCondition every 500 milliseconds until it returns successfully.
        // A successful return value for the ExpectedCondition function type is a Boolean value of true, or a non-null object.
        WebElement pageHeading = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("page-heading")));
        Assert.assertEquals("AUTHENTICATION", pageHeading.getText());
    }

    public void InsertCorrectEmailToCreateAccount () {
        //Add date to the user email so that each registration is unique
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy-HH.mm.ss");
        Date date = new Date();
        String formattedDate = dateFormat.format(date);
        //Save email address so it can be used to login
        HelperFunctions.emailAddress = "test" + formattedDate + "@gmail.com";
        driver.findElement(By.id("email_create")).sendKeys(HelperFunctions.emailAddress);

    }

    public void ClickCreateAccountButton() {
        driver.findElement(By.id("SubmitCreate")).click();
    }

    public void InsertCorrectEmailToLogin() {
        driver.findElement(By.id("email")).sendKeys(HelperFunctions.emailAddress);
    }

    public void InsertCorrectPasswordToLogin() {
        driver.findElement(By.id("passwd")).sendKeys("Test1234!");
    }

    public void ClickSignInButton() {
        driver.findElement(By.id("SubmitLogin")).click();
    }
}
