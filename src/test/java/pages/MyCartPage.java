package pages;

import org.openqa.selenium.By;

import static config.Config.EXPLICIT_WAIT_TIME_SEC;
import static utils.DriverProvider.getCurrentDriver;
import static utils.ExplicitWaitsReturnWebElm.elementToBeClickable;
import static utils.ExplicitWaitsReturnWebElm.visibilityOfElement;

public class MyCartPage extends BasePage {
    By priceOfProductInCartList = By.className("cart-price");
    By placeAnOrderButton = By.id("cart-submit");
    By popUpMessage = By.className("jqimessage");
    public String missingDeliveryMethodMessageText = "Please choose the most convenient method of delivery!";

    public boolean ifPriceOfProductCorrect(String price) {
        String priceString = visibilityOfElement(EXPLICIT_WAIT_TIME_SEC, priceOfProductInCartList).getText();
        return price.equals(priceString.substring(0,priceString.length()-1));
    }

    public boolean ifPopUpMessageIsDisplayed() {
        return visibilityOfElement(EXPLICIT_WAIT_TIME_SEC,popUpMessage).isDisplayed();
    }

    public String getTextOfPopUpMessage() {
        return getCurrentDriver().findElement(popUpMessage).getText();
    }

    public void placeAnOrderClick() {
        elementToBeClickable(EXPLICIT_WAIT_TIME_SEC, placeAnOrderButton).click();
    }
}
