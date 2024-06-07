package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static utils.DriverProvider.closeDriver;
import static utils.DriverProvider.getCurrentDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static common.Config.*;
import static common.Config.EXPLICIT_WAIT;

public class CommonAction {
    private static WebDriver driver = null;

    public CommonAction() {
    }

    public static WebDriver createDriver() {
        if (driver == null) {
            switch (BROWSER) {
                case "chrome" -> driver = new ChromeDriver();
                case "firefox" -> driver = new FirefoxDriver();
                default -> Assert.fail("Unsupported browser: " + BROWSER);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        }
        return driver;
    }
    public WebElement waitElementIsVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement waitElementIsClickable(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public List<WebElement> collectListOfWebElements (By locator){
        return getCurrentDriver().findElements(locator);
    }

    public String getUrlFromWebElement (List<WebElement> webElements){
        for(WebElement link: webElements){
            String url = link.getAttribute("href");
            if(url !=null && !url.isEmpty()) return url;
        }
        return "no url`s here";
    }
}

