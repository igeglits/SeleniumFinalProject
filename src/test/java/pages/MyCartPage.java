package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.DriverProvider.getCurrentDriver;

public class MyCartPage extends BasePage {
    By priceInLineOfProduct = By.className("cart-price");
    By placeAnOrder = By.id("cart-submit");
    By popUpMessage = By.className("jqimessage");
    public String missingDeliveryMethodMessageText = "Please choose the most convenient method of delivery!";

    public boolean ifPriceOfProductCorrect(String price) {
        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(5));
        WebElement priceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(priceInLineOfProduct));
        String priceString = priceElement.getText();
        return price.equals(priceString.substring(0,priceString.length()-1));
    }

    public boolean ifPopUpMessageIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(5));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(popUpMessage));
        return message.isDisplayed();
    }

    public String getTextOfPopUpMessage() {
        return getCurrentDriver().findElement(popUpMessage).getText();
    }

    public void placeAnOrderClick() {
        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(5));
        WebElement orderButton = wait.until(ExpectedConditions.elementToBeClickable(placeAnOrder));
        orderButton.click();
    }
}
