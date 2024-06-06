package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.DriverProvider.getCurrentDriver;


public class HomePage {


    By registrationId = By.id("topCartRegLbl");
    By userFieldName = By.name("login");
    By passwordFieldName = By.name("passw");
    By logInButtonName = By.xpath("//*[@id='topLogin']/div/button");
    String errorMessage = "Login and / or password is not correct.";
    By mainCentreFieldId = By.id("mainCenter");



    public void login(String loginName, String password){
        WebElement registrationButton = getCurrentDriver().findElement(registrationId);
        WebElement userField = getCurrentDriver().findElement(userFieldName);
        WebElement passwordField = getCurrentDriver().findElement(passwordFieldName);
        WebElement logInButton = getCurrentDriver().findElement(logInButtonName);

        registrationButton.click();
        userField.sendKeys(loginName);
        passwordField.sendKeys(password);
        logInButton.click();
    }
    public Boolean isErrorMessageDisplayed(){
        try{
            String errorMessageText = getCurrentDriver().findElement(mainCentreFieldId).getText();
            return errorMessageText.equals(errorMessage);
        }catch(Exception e){
            return false;
        }
    }
}
