package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static utils.DriverProvider.getCurrentDriver;


public class BasePage {


    By registrationId = By.id("topCartRegLbl");
    By userFieldName = By.name("login");
    By passwordFieldName = By.name("passw");
    By logInButtonNameXpath = By.xpath("//*[@id='topLogin']/div/button");
    String errorMessage = "Login and / or password is not correct.";
    By mainCentreFieldId = By.id("mainCenter");
    By helloUserFieldId = By.id("userLogedLeft");
    By visibleElementOnPageWithUrl = By.xpath("//a[starts-with(@href, 'https')]");
    By editProfileLink = By.xpath("//*[@id='userLogedLeft']/a[1]");

    public void login(String loginName, String password) {
        WebElement registrationButton = getCurrentDriver().findElement(registrationId);
        WebElement userField = getCurrentDriver().findElement(userFieldName);
        WebElement passwordField = getCurrentDriver().findElement(passwordFieldName);
        WebElement logInButton = getCurrentDriver().findElement(logInButtonNameXpath);

        registrationButton.click();
        userField.sendKeys(loginName);
        passwordField.sendKeys(password);
        logInButton.click();
    }

    public Boolean isErrorMessageDisplayed() {
        try {
            String errorMessageText = getCurrentDriver().findElement(mainCentreFieldId).getText();
            return errorMessageText.equals(errorMessage);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isHelloUserNameDisplayed() {
        try {
            getCurrentDriver().findElement(helloUserFieldId);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<WebElement> collectVisibleElementsWithUrlToList() {
        return getCurrentDriver().findElements(visibleElementOnPageWithUrl);
    }

    public List<String> getLinkFromWebElement(List<WebElement> webElements) {
        return webElements.stream()
                .map(e -> e.getAttribute("href"))
                .toList();
    }

    public void openEditProfilePage(){
        getCurrentDriver().findElement(editProfileLink).click();
    }
}
