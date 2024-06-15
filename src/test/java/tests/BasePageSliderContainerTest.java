package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;

import static utils.DriverProvider.getCurrentDriver;
import static utils.SliderUtilities.ifSlidesChangeWithCorrectSlideUrl;

public class BasePageSliderContainerTest extends BaseTest {
    @Test
    void testSliderInitialization() {
        BasePage basePage = new BasePage();
        Assert.assertTrue(getCurrentDriver().findElement(basePage.sliderContainer)
                .isDisplayed());
    }

    @Test
    public void testAutoSlideTransition() {
        BasePage basePage = new BasePage();
        WebElement sliderContainer = getCurrentDriver().findElement(basePage.sliderContainer);
        Assert.assertTrue(ifSlidesChangeWithCorrectSlideUrl(sliderContainer));
    }
}
