package tests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.RegistrationPage;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
@Ignore
public class RegistrationPageTest extends BaseTest {

    @Test(priority = 1)
    void checkRegistrationWithAlreadyRegisteredEmailAndUsername(){
        BasePage basePage = new BasePage();
        RegistrationPage registrationPage = new RegistrationPage();

        basePage.openRegistrationPage();
        registrationPage.fillInRegistrationFormClickRegister("Name",
                "Address",
                "123456",
                "igeglits@mail.ru",
                "testName",
                "qwerty");

        Assert.assertTrue(registrationPage.isThisLoginIsAlreadyTakenMessageDisplayed());
        Assert.assertTrue(registrationPage.isTextMessageCorrect("This login is already taken!",
                registrationPage.firstErrorMessage));
    }

    @Test(priority = 2)
    void checkRegistrationWithAllFieldsEmpty() {
        BasePage basePage = new BasePage();
        RegistrationPage registrationPage = new RegistrationPage();

        basePage.openRegistrationPage();
        registrationPage.fillInRegistrationFormClickRegister("", "", "", "", "", "");
        Assert.assertTrue(registrationPage.isPleaseCheckIfTheFormIsFilledInCorrectlyDisplayed());
        Assert.assertTrue(registrationPage.isTextMessageCorrect("Please check if the form is filled in correctly!",
                registrationPage.secondErrorMessage));
        Assert.assertTrue(registrationPage.isFieldBoarderColorRed(registrationPage.inputName));
        Assert.assertTrue(registrationPage.isFieldBoarderColorRed(registrationPage.inputAddress));
        Assert.assertTrue(registrationPage.isFieldBoarderColorRed(registrationPage.inputPhone));
        Assert.assertTrue(registrationPage.isFieldBoarderColorRed(registrationPage.inputEmail));
        Assert.assertTrue(registrationPage.isFieldBoarderColorRed(registrationPage.inputUsername));
        Assert.assertTrue(registrationPage.isFieldBoarderColorRed(registrationPage.inputPassword));
    }

}
