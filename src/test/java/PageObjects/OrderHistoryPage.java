package PageObjects;

import HelpClasses.HelperFunctions;
import cucumber.api.java.eo.Do;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OrderHistoryPage {

    private WebDriver driver = HelperFunctions.Instance().GetDriver();

    public void VerifyIfOpen() {
        WebElement orders = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("block-history")));
        Assert.assertTrue(orders.isDisplayed());
    }

    public void VerifyIfBoughtItemIsInList() {
        //Since orders are listed in a table, first we save all table rows in a list. After that, we go through that list and check if the text from each row matches the value saved as order reference.
        List<WebElement> listOfOrders = driver.findElements(By.xpath("//*[@id='order-list']/tbody/tr[1]"));
        for (WebElement row : listOfOrders) {
            if (row.getText().contains(HelperFunctions.orderReference)) {
                return;
            }
        }
        Assert.fail();
    }
}
