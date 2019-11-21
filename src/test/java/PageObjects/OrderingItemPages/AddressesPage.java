package PageObjects.OrderingItemPages;

import HelpClasses.HelperFunctions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressesPage {

    private WebDriver driver = HelperFunctions.Instance().GetDriver();

    public void VerifyIfOpen() {
        WebElement address = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("address_delivery")));
        Assert.assertTrue(address.isDisplayed());
    }

    public void VerifyAddressIsCorrect() {
        //napravi da se provjerava da je tekst adrese isti kao onaj koji je unešen kod registracije. Vjerojatno će trebati varijable u Helper funcitons u koje će se spremiti podaci pa se onda uspoređivati s njima.
        //može se napraviti i da se uspoređuje samo sa čistim tesktom koji je unesen, to je lakše ali ne znam dal je ispravno jer onda ako se promijeni na jednom mjestu (npr kod registracije)
        //više neće vrijediti tu.
    }

    public void ProceedToCheckout() {
        //find button Proceed to checkout using it's parent, element p with class cart_navigation clearfix. First parent is found and then his child that has title we need.
        driver.findElement(By.xpath("//p[@class='cart_navigation clearfix']/button[@name='processAddress']")).click();
    }
}
