package tests;

import config.ColorRGB;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.RegistrationPage;

//@Ignore
public class RegistrationTest extends BaseTest {

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
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        RegistrationPage registrationPage = new RegistrationPage();

        basePage.openRegistrationPage();
        registrationPage.fillInRegistrationFormAndClickRegister("", "", "", "", "", "");
        softAssert.assertTrue(registrationPage.isMessagePleaseCheckIfTheFormIsFilledInCorrectlyDisplayed());
        softAssert.assertTrue(registrationPage.isTextMessageCorrect(registrationPage.incorrectFormMessageText,
                registrationPage.incorrectFormErrorMessage));
        softAssert.assertTrue(registrationPage.isFieldBoarderExpectedColor(registrationPage.inputName, ColorRGB.RED.getColor()));
        softAssert.assertTrue(registrationPage.isFieldBoarderExpectedColor(registrationPage.inputAddress, ColorRGB.RED.getColor()));
        softAssert.assertTrue(registrationPage.isFieldBoarderExpectedColor(registrationPage.inputPhone, ColorRGB.RED.getColor()));
        softAssert.assertTrue(registrationPage.isFieldBoarderExpectedColor(registrationPage.inputEmail, ColorRGB.RED.getColor()));
        softAssert.assertTrue(registrationPage.isFieldBoarderExpectedColor(registrationPage.inputUsername, ColorRGB.RED.getColor()));
        softAssert.assertTrue(registrationPage.isFieldBoarderExpectedColor(registrationPage.inputPassword, ColorRGB.RED.getColor()));

        softAssert.assertAll();
    }

}
