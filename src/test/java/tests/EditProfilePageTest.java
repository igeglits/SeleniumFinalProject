package tests;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.EditProfilePage;

import static utils.DriverProvider.getCurrentDriver;
import static utils.StringRandomizer.generateRandomString;

@Ignore
public class EditProfilePageTest extends BaseTest {
    private final String newNameFieldEngLiteralValue = generateRandomString(8);
    private final String newAddressFieldEngLiteralValue = generateRandomString(10);

    @Test(priority = 1)
    @Parameters({"good_login", "good_password"})
    void nameFieldValueChangeSuccessMessageDisplayed(String userName, String password) {
        var editProfilePage = getEditProfilePage(userName, password);
        editProfilePage.changeInputFieldValue(newNameFieldEngLiteralValue,
                editProfilePage.inputFieldName);

        Assert.assertTrue(editProfilePage.isSuccessEditionMessageDisplayed());
    }

    @Test(priority = 2)
    @Parameters({"good_login", "good_password"})
    void checkNameFieldForNewValue(String userName, String password) {
        var editProfilePage = getEditProfilePage(userName, password);

        Assert.assertTrue(editProfilePage.checkValueEqualityOf(newNameFieldEngLiteralValue, editProfilePage.inputFieldName));
    }

    @Test(priority = 3)
    @Parameters({"good_login", "good_password"})
    void addressFieldValueChangeSuccessMessageDisplayed(String userName, String password) {
        var editProfilePage = getEditProfilePage(userName, password);
        editProfilePage.changeInputFieldValue(newAddressFieldEngLiteralValue,
                editProfilePage.inputFieldAddress);

        Assert.assertTrue(editProfilePage.isSuccessEditionMessageDisplayed());
    }

    @Test(priority = 4)
    @Parameters({"good_login", "good_password"})
    void checkAddressFieldForNewValue(String userName, String password) {
        var editProfilePage = getEditProfilePage(userName, password);

        Assert.assertTrue(editProfilePage.checkValueEqualityOf(newAddressFieldEngLiteralValue, editProfilePage.inputFieldAddress));
    }

    @Test(priority = 5)
    @Parameters({"good_login", "good_password"})
    void nameFieldEmptyValueCheck(String userName, String password) {
        var editProfilePage = getEditProfilePage(userName, password);
        editProfilePage.changeInputFieldValue("",
                editProfilePage.inputFieldAddress);

        Assert.assertTrue(getCurrentDriver().findElement(editProfilePage.errorMessage).isDisplayed());
    }

    @Test(priority = 6)
    @Parameters({"good_login", "good_password"})
    void nameFieldValueAsTwoEngLiteralCharCheck(String userName, String password) {
        var editProfilePage = getEditProfilePage(userName, password);
        editProfilePage.changeInputFieldValue("AA",
                editProfilePage.inputFieldAddress);

        Assert.assertTrue(getCurrentDriver().findElement(editProfilePage.errorMessage).isDisplayed());
    }

    @Test(priority = 7)
    @Parameters({"good_login", "good_password"})
    void nameFieldValueAsThreeSpecialCharCheck(String userName, String password) {
        var editProfilePage = getEditProfilePage(userName, password);
        editProfilePage.changeInputFieldValue("@#$",
                editProfilePage.inputFieldAddress);

        Assert.assertTrue(getCurrentDriver().findElement(editProfilePage.errorMessage).isDisplayed());
    }

    @Test(priority = 8)
    @Parameters({"good_login", "good_password"})
    void nameFieldValueAsThreeNumericCharCheck(String userName, String password) {
        var editProfilePage = getEditProfilePage(userName, password);
        editProfilePage.changeInputFieldValue("123",
                editProfilePage.inputFieldAddress);

        Assert.assertTrue(getCurrentDriver().findElement(editProfilePage.errorMessage).isDisplayed());
    }

    @Test(priority = 9)
    @Parameters({"good_login", "good_password"})
    void nameFieldValueAsThreeSpacesCheck(String userName, String password) {
        var editProfilePage = getEditProfilePage(userName, password);
        editProfilePage.changeInputFieldValue("   ",
                editProfilePage.inputFieldAddress);

        Assert.assertTrue(getCurrentDriver().findElement(editProfilePage.errorMessage).isDisplayed());
    }

    private static EditProfilePage getEditProfilePage(String userName, String password) {
        BasePage basePage = new BasePage();
        EditProfilePage editProfilePage = new EditProfilePage();

        basePage.login(userName, password);
        basePage.openEditProfilePage();
        return editProfilePage;
    }
}
