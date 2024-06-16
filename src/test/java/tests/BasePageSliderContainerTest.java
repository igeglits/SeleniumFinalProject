package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

        int windowCentreX=(getCurrentDriver().manage()
                .window()
                .getSize()
                .getWidth())/2;
        int windowCentreY = 0;
        new Actions(getCurrentDriver())
                .moveToElement(getCurrentDriver().findElement(By.tagName("body")),windowCentreX, windowCentreY)
                .click()
                .perform();

        Assert.assertTrue(ifSlidesChangeWithCorrectSlideUrl(sliderContainer));
    }
}
