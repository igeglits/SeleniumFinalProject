package utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.DriverProvider.getCurrentDriver;

public class ExplicitWaitsReturnWebElm {

    public static WebElement visibilityOfElement(int durationSec, By locator) {
        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(durationSec));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement elementToBeClickable(int durationSec, By locator) {
        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(durationSec));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


}
