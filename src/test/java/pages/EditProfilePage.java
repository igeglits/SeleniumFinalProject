package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Objects;

import static utils.DriverProvider.getCurrentDriver;

public class EditProfilePage extends BasePage {
    public By inputFieldName = By.xpath("//input[@name='clients_name']");
    public By inputFieldAddress = By.xpath("//input[@name='clients_address']");
    public By inputFieldPhone = By.xpath("//input[@name='clients_phone']");
    public By inputFieldEmail = By.xpath("//input[@name='clients_email']");
    public By inputFieldUsername = By.xpath("//input[@name='clients_login']");
    public By buttonSubmit = By.xpath("//*[@id='reg-form']/div[2]/button");
    public By successEditionTextField = By.xpath("//div[@class='message']");
    public By errorMessage = By.id("reg-error");

    public void changeInputFieldValue(String string, By locator) {
        WebElement inputField = getCurrentDriver().findElement(locator);
        inputField.clear();
        inputField.sendKeys(string);
        getCurrentDriver().findElement(buttonSubmit).click();
    }

    public boolean isSuccessEditionMessageDisplayed() {
        try {
            getCurrentDriver().findElement(successEditionTextField);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public boolean checkValueEqualityOf(String string, By locator) {
        WebElement inputField = getCurrentDriver().findElement(locator);
        return Objects.equals(inputField.getAttribute("value"), string);
    }

}
