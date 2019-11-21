package PageObjects.OrderingItemPages;

import HelpClasses.HelperFunctions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {

    private WebDriver driver = HelperFunctions.Instance().GetDriver();

    public void VerifyIfOpen() {
        WebElement payment = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("HOOK_PAYMENT")));
        Assert.assertTrue(payment.isDisplayed());
    }

    public void CheckIfTotalCostIsRight() {
        Assert.assertEquals(HelperFunctions.totalPrice, Double.parseDouble(driver.findElement(By.id("total_price")).getText().substring(1)), 0.0);
    }

    public void SelectBankWirePaymentType() {
        driver.findElement(By.className("bankwire")).click();
    }

    public void VerifyPaymentTypeSelected() {
        Assert.assertEquals("BANK-WIRE PAYMENT.", driver.findElement(By.className("page-subheading")).getText());
    }

    public void ConfirmOrder() {
        //find button I confirm my order using it's parent, element p with class cart_navigation clearfix. First parent is found and then his child that has title we need.
        driver.findElement(By.xpath("//p[@class='cart_navigation clearfix']/button")).click();
    }

    public void VerifyOrderIsComplete() {
        WebElement orderConformation = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("page-heading")));
        Assert.assertEquals("ORDER CONFIRMATION", orderConformation.getText());
    }

    public void VerifyAmountIsRight() {
        String priceOnConformation = driver.findElement(By.xpath("//span[@class='price']/*")).getText();
        Assert.assertEquals(HelperFunctions.totalPrice, Double.parseDouble(priceOnConformation.substring(1)), 0.0);
    }

    public void SaveOrderReference() {
        //The order reference is a part of text. First we get the full text, then split it by words surrounding the order reference
        // and save the 3 parts in a field (string before reference, reference and string after the reference).
        //After that, we save the middle part as order reference.
        String orderConformationText = driver.findElement(By.className("box")).getText();

        /*
        //The order reference is a part of text. First we get the full text, then split it into sentences and then split the sentence which contains order reference.

        String[] conformationTextSentences = orderConformationText.split("\n");
        String sentenceWithOrderReference = conformationTextSentences[6];
        String orderReference = sentenceWithOrderReference.substring(47, 56);
        System.out.println(orderReference);
        HelperFunctions.orderReference = orderReference;
        */


        String[] strings = orderConformationText.split("reference | in the subject ");
        HelperFunctions.orderReference = strings[1];
    }

    public void ClickBackToOrders() {
        driver.findElement(By.xpath("//p[@class='cart_navigation exclusive']/a[@title='Back to orders']")).click();
    }
}
