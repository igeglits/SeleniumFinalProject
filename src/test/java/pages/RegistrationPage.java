package pages;

import models.UserForRegistration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static utils.DriverProvider.getCurrentDriver;

public class RegistrationPage extends BasePage {

    public By inputName = By.xpath("//input[@name='clients_name']");
    public By inputAddress = By.xpath("//input[@name='clients_address']");
    public By inputPhone = By.xpath("//input[@name='clients_phone']");
    public By inputEmail = By.xpath("//input[@name='clients_email']");
    public By inputUsername = By.xpath("//input[@name='clients_login']");
    public By inputPassword = By.xpath("//input[@name='clients_password']");
    private By checkboxAgreement = By.id("uagreem");
    private By registerButton = By.xpath(("//*[@id='reg-form']/div[2]/button"));
    public By loginTakenErrorMessage = By.xpath("//div[@class='reg-error'][1]");
    public By incorrectFormErrorMessage = By.id("reg-error");
    public String loginTakenMessageText = "This login is already taken!";
    public String incorrectFormMessageText = "Please check if the form is filled in correctly!";

    public void fillInRegistrationFormAndClickRegister(UserForRegistration user) {
        getCurrentDriver().findElement(inputName).sendKeys(user.name());
        getCurrentDriver().findElement(inputAddress).sendKeys(user.address());
        getCurrentDriver().findElement(inputPhone).sendKeys(user.phone());
        getCurrentDriver().findElement(inputEmail).sendKeys(user.email());
        getCurrentDriver().findElement(inputUsername).sendKeys(user.userName());
        getCurrentDriver().findElement(inputPassword).sendKeys(user.password());
        var checkbox = getCurrentDriver().findElement(checkboxAgreement);
        if (!checkbox.isSelected()) {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) getCurrentDriver();
            jsExecutor.executeScript("arguments[0].click();", checkbox);
        }
        getCurrentDriver().findElement(registerButton).click();
    }

    public boolean isMessageThisLoginIsAlreadyTakenDisplayed() {
        try {
            getCurrentDriver().findElement(loginTakenErrorMessage);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean isMessagePleaseCheckIfTheFormIsFilledInCorrectlyDisplayed() {
        try {
            getCurrentDriver().findElement(incorrectFormErrorMessage);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public boolean isTextMessageCorrect(String message, By locator) {
        return message.equals(getCurrentDriver().findElement(locator).getText());
    }

    public boolean isFieldBoarderExpectedColor(By locator, String expectedСolor) {
        JavascriptExecutor js = (JavascriptExecutor) getCurrentDriver();
        WebElement field = getCurrentDriver().findElement(locator);
        String borderColor = (String) js.executeScript(
                "return window.getComputedStyle(arguments[0]).borderColor",
                field
        );
        return expectedСolor.equals(borderColor);
    }
}

