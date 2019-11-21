package HelpClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelperFunctions {

    private static HelperFunctions instance = null;
    private static WebDriver driver = null;
    public static String emailAddress = "";
    public static double unitPrice = 0;
    public static double totalItemPrice = 0;
    public static double allProductsPrice = 0;
    public static double shippingPrice = 0;
    public static double totalPrice = 0;
    public static String orderReference = "";

    public void CreateDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static HelperFunctions Instance() {
        if (instance == null) {
            instance = new HelperFunctions();
        }
        return instance;
    }

    public WebDriver GetDriver() {
        return driver;
    }

    public void CloseDriver() {
        driver.close();
        driver.quit();
    }


}
