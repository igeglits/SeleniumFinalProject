package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import static Config.Config.BROWSER;

public class DriverProvider {
    private static WebDriver driver = null;

    public static WebDriver getCurrentDriver() {
        if (driver == null) {
            switch (BROWSER) {
                case "chrome" -> driver = new ChromeDriver();
                case "firefox" -> driver = new FirefoxDriver();
                default -> Assert.fail("Unsupported browser: " + BROWSER);
            }
            driver.manage().window().maximize();
           // driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        }
        return driver;
    }


    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}
