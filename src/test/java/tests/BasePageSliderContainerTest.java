package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.BasePage;

import static utils.ClickOnSpot.clickEmptySpotOnScreenTopCentre;
import static utils.DriverProvider.getCurrentDriver;
import static utils.Scrolls.scrollToUpTop;
import static utils.SliderUtilities.ifSlidesChangeWithCorrectSlideUrl;
//@Ignore
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
        scrollToUpTop();
        Assert.assertTrue(ifSlidesChangeWithCorrectSlideUrl(sliderContainer));
    }
}
