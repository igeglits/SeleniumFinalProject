package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;
import static utils.DriverProvider.getCurrentDriver;

public class SliderUtilities {

    public static boolean ifSlidesChangeWithCorrectSlideUrl(WebElement sliderContainer) {
        List<String> slidesUrl = sliderContainer.findElements(By.className("label_text")).stream()
                .map(element -> element.findElement(By.cssSelector(".label_text a")).getAttribute("href"))
                .collect(Collectors.toList());
        slidesUrl.forEach(System.out::println);

        for (int i = 0; i < slidesUrl.size(); i++) {
            WebElement currentSlide = getCurrentDriver().findElement(By.className("image"));
            String currentSlideUrl = currentSlide.findElement(By.xpath("//*[@id=\"box_skitter_large\"]/div/div/a")).getAttribute("href");
            System.out.println("Current slide " + currentSlideUrl);
            try {
                Assert.assertEquals(currentSlideUrl, slidesUrl.get(i));
                sleep(7000);
                /*new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(15))
                        .until(ExpectedConditions.not(ExpectedConditions.visibilityOf(currentSlide)));*/
            } catch (Exception e) {
                return false;
            }

        }
        return true;
    }
}
