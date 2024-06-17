package utils;

import org.openqa.selenium.JavascriptExecutor;

import static utils.DriverProvider.getCurrentDriver;

public class Scrolls {

    public static void scrollToUpTop(){
        JavascriptExecutor js = (JavascriptExecutor) getCurrentDriver();
        js.executeScript("window.scrollTo(0, 0);");
    }
}
