package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.MyCartPage;

public class MyCartPageTest extends BaseTest {

    @Test(priority = 1)
    @Parameters({"good_login", "good_password"})
    void priceInCartCorrect(String userName, String password) {
        BasePage basePage = new BasePage();
        MyCartPage myCartPage = new MyCartPage();

        basePage.login(userName, password);
        basePage.backToBasePage();
        basePage.addFirstProductFromBasePageToCart();
        String price = basePage.getPriceOfFirstProductFromBasePage();
        basePage.openCart();
        Assert.assertTrue(myCartPage.ifPriceOfProductCorrect(price));

    }

    @Test(priority = 2)
    @Parameters({"good_login", "good_password"})
    void placeAnOrderWithNoDeliveryChosenTriggersErrorMessage(String userName, String password) {
        BasePage basePage = new BasePage();
        MyCartPage myCartPage = new MyCartPage();

        basePage.login(userName, password);
        basePage.backToBasePage();
        basePage.addFirstProductFromBasePageToCart();
        basePage.openCart();
        myCartPage.placeAnOrderClick();
        Assert.assertTrue(myCartPage.ifPopUpMessageIsDisplayed());
        Assert.assertEquals(myCartPage.getTextOfPopUpMessage(),
                myCartPage.missingDeliveryMethodMessageText);
    }
}
