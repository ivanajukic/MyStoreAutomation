package HelpClasses;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class XWebDriver {

    private org.openqa.selenium.WebDriver driver;

    public org.openqa.selenium.WebDriver Create() {

        System.setProperty("webdriver.chrome.driver", "D:\\Programs\\chromedriver.exe");
        driver = new ChromeDriver();

/*
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
*/
        return driver;

    }

    @After
    public void CloseDriver(){
        driver.close();
    }
}
