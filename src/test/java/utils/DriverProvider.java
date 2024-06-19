package utils;

import config.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static config.Config.BROWSER;

public class DriverProvider {
    private static WebDriver driver = null;

    public static WebDriver getCurrentDriver() {
        if (driver == null) {
            switch (BROWSER) {
                case "chrome" -> driver = new ChromeDriver();
                case "firefox" -> driver = new FirefoxDriver();
                default -> System.out.println("No implementation for " + BROWSER);
            }
            assert driver != null;
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
