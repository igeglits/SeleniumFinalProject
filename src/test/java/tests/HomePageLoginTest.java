package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageLoginTest extends BaseTest{

    @Test
    @Parameters({"good_login", "good_password"})
    void successfulCheck(String userName, String password) {
        HomePage homePage = new HomePage();
        User standartUser = new User(userName, password);
        homePage.login(standartUser.getUserName(), standartUser.getPassword());
        Assert.assertFalse(homePage.isErrorMessageDisplayed());
    }
    @Test
    @Parameters({"good_login", "good_password"})
    void wrongPasswordCheck(String userName, String password) {
        HomePage homePage = new HomePage();
        homePage.login(userName,password+"1");
        Assert.assertTrue(homePage.isErrorMessageDisplayed());
    }
}
