package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
@Ignore
public class LoginTest extends BaseTest{

    @Test
    @Parameters({"good_login", "good_password"})
    void successfulLoginCheck(String userName, String password) {
        BasePage basePage = new BasePage();
        User standartUser = new User(userName, password);

        basePage.login(standartUser.getUserName(), standartUser.getPassword());
        Assert.assertFalse(basePage.isErrorMessageDisplayedAndTextCorrect());
        Assert.assertTrue(basePage.isHelloUserNameDisplayed());
    }
    @Test
    @Parameters({"good_login", "good_password"})
    void wrongPasswordCheck(String userName, String password) {
        BasePage basePage = new BasePage();

        basePage.login(userName,password+"1");
        Assert.assertTrue(basePage.isErrorMessageDisplayedAndTextCorrect());
        Assert.assertFalse(basePage.isHelloUserNameDisplayed());
    }

    @Test
    @Parameters({"good_login", "good_password"})
    void wrongUserNameCheck(String userName, String password) {
        BasePage basePage = new BasePage();

        basePage.login(userName+"1", password);
        Assert.assertTrue(basePage.isErrorMessageDisplayedAndTextCorrect());
        Assert.assertFalse(basePage.isHelloUserNameDisplayed());
    }

    @Test
    @Parameters({"good_login", "good_password"})
    void wrongUserNameAndPasswordCheck(String userName, String password) {
        BasePage basePage = new BasePage();

        basePage.login(userName+"1", password+"1");
        Assert.assertTrue(basePage.isErrorMessageDisplayedAndTextCorrect());
        Assert.assertFalse(basePage.isHelloUserNameDisplayed());
    }
}
