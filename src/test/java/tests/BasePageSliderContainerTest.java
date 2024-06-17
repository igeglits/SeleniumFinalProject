package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;

import static utils.ClickSpot.clickEmptySpotOnScreenTopCentre;
import static utils.DriverProvider.getCurrentDriver;
import static utils.SliderUtilities.ifSlidesChangeWithCorrectSlideUrl;

public class BasePageSliderContainerTest extends BaseTest {
    @Test(priority = 1)
    void testSliderInitialization() {
        BasePage basePage = new BasePage();
        Assert.assertTrue(getCurrentDriver().findElement(basePage.sliderContainer)
                .isDisplayed());
    }

    @Test(priority = 2)
    public void testAutoSlideTransition() {
        BasePage basePage = new BasePage();
        WebElement sliderContainer = getCurrentDriver().findElement(basePage.sliderContainer);
        clickEmptySpotOnScreenTopCentre();
        Assert.assertTrue(ifSlidesChangeWithCorrectSlideUrl(sliderContainer));
    }
}
