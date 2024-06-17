package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static utils.DriverProvider.getCurrentDriver;

public class ClickSpot {

    public static void clickEmptySpotOnScreenTopCentre(){
        int windowCentreX=(getCurrentDriver().manage()
                .window()
                .getSize()
                .getWidth())/2;
        int windowCentreY = 0;
        new Actions(getCurrentDriver())
                .moveToElement(getCurrentDriver().findElement(By.tagName("body")),windowCentreX, windowCentreY)
                .click()
                .perform();
    }
}
