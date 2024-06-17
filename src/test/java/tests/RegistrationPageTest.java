package tests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.RegistrationPage;

@Ignore
public class RegistrationPageTest extends BaseTest {

    @Test(priority = 1)
    void checkRegistrationWithAlreadyRegisteredEmailAndUsername() {
        BasePage basePage = new BasePage();
        RegistrationPage registrationPage = new RegistrationPage();

        basePage.openRegistrationPage();
        registrationPage.fillInRegistrationFormAndClickRegister("Name",
                "Address",
                "123456",
                "igeglits@mail.ru",
                "testName",
                "qwerty");

        Assert.assertTrue(registrationPage.isMessageThisLoginIsAlreadyTakenDisplayed());
        Assert.assertTrue(registrationPage.isTextMessageCorrect(registrationPage.loginTakenMessageText,
                registrationPage.loginTakenErrorMessage));
    }

    @Test(priority = 2)
    void checkRegistrationWithAllFieldsEmpty() {
        BasePage basePage = new BasePage();
        RegistrationPage registrationPage = new RegistrationPage();

        basePage.openRegistrationPage();
        registrationPage.fillInRegistrationFormAndClickRegister("", "", "", "", "", "");
        Assert.assertTrue(registrationPage.isMessagePleaseCheckIfTheFormIsFilledInCorrectlyDisplayed());
        Assert.assertTrue(registrationPage.isTextMessageCorrect(registrationPage.incorrectFormMessageText,
                registrationPage.incorrectFormErrorMessage));
        Assert.assertTrue(registrationPage.isFieldBoarderColorRed(registrationPage.inputName));
        Assert.assertTrue(registrationPage.isFieldBoarderColorRed(registrationPage.inputAddress));
        Assert.assertTrue(registrationPage.isFieldBoarderColorRed(registrationPage.inputPhone));
        Assert.assertTrue(registrationPage.isFieldBoarderColorRed(registrationPage.inputEmail));
        Assert.assertTrue(registrationPage.isFieldBoarderColorRed(registrationPage.inputUsername));
        Assert.assertTrue(registrationPage.isFieldBoarderColorRed(registrationPage.inputPassword));
    }

}
