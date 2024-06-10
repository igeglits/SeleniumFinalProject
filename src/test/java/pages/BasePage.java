package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static utils.DriverProvider.getCurrentDriver;


public class BasePage {


    By registrationAndLogin = By.id("topCartRegLbl");
    By userFieldName = By.name("login");
    By passwordFieldName = By.name("passw");
    By logInButtonNameXpath = By.xpath("//*[@id='topLogin']/div/button");
    String errorMessage = "Login and / or password is not correct.";
    By loginErrorMessage = By.className("message");
    By helloUserField = By.id("userLogedLeft");
    By visibleElementOnPageWithUrl = By.xpath("//a[starts-with(@href, 'https')]");
    By editProfileLink = By.xpath("//*[@id='userLogedLeft']/a[1]");
    By registrationPageLink = By.id("doregistr");
    By ayurvedicTeaPageLink = By.xpath("//*[@id='leftMenu']/li[1]/a");
    By firstPrice = By.xpath("//span[@class='list-price'][1]");
    By firstAddToCartButton = By.className("list-buy");
    By cartButton = By.xpath("//a[@rel='nofollow'][1]");
    By priceOfCartBesideCartButton = By.id("topCartAmount");
    By backToBasePageCentreIcon = By.id("topMenuMid");

    public void login(String loginName, String password) {
        WebElement registrationButton = getCurrentDriver().findElement(registrationAndLogin);
        WebElement userField = getCurrentDriver().findElement(userFieldName);
        WebElement passwordField = getCurrentDriver().findElement(passwordFieldName);
        WebElement logInButton = getCurrentDriver().findElement(logInButtonNameXpath);

        registrationButton.click();
        userField.sendKeys(loginName);
        passwordField.sendKeys(password);
        logInButton.click();
    }

    public Boolean isErrorMessageDisplayedAndTextCorrect() {
        try {
            String errorMessageText = getCurrentDriver().findElement(loginErrorMessage).getText();
            return errorMessageText.equals(errorMessage);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isHelloUserNameDisplayed() {
        try {
            getCurrentDriver().findElement(helloUserField);
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

    public void openAyurvedicTeaPage() {
        getCurrentDriver().findElement(ayurvedicTeaPageLink).click();
    }

    public void openEditProfilePage() {
        getCurrentDriver().findElement(editProfileLink).click();
    }

    public void openRegistrationPage() {
        getCurrentDriver().findElement(registrationAndLogin).click();
        getCurrentDriver().findElement(registrationPageLink).click();
    }

    public void openCart() {
        getCurrentDriver().findElement(cartButton).click();
    }

    public void addFirstProductFromBasePageToCart() {
        WebDriverWait wait = new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(5));
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(firstAddToCartButton));
        addToCartButton.click();
    }

    public String getPriceOfFirstProductFromBasePage() {
        String price = getCurrentDriver().findElement(firstPrice).getText();
        return price.substring(0, price.length() - 1);
    }

    public boolean ifCartAmountCorrect(String price) {
        return price.equals(getCurrentDriver().findElement(priceOfCartBesideCartButton).getText());
    }

    public void backToBasePage() {
        getCurrentDriver().findElement(backToBasePageCentreIcon).click();
    }
}
