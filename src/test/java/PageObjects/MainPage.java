package PageObjects;

import HelpClasses.HelperFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    WebDriver driver = HelperFunctions.Instance().GetDriver();

    public void GoToMyStorePage () {
        driver.navigate().to("http://automationpractice.com");
    }

    public void OpenSignInPage () {
        driver.findElement(By.className("header_user_info")).click();
    }

}

