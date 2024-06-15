package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static utils.DriverProvider.getCurrentDriver;

public class SliderUtilities {

    public static boolean ifSlidesChangeWithCorrectSlideUrl(WebElement sliderContainer) {
        List<String> slidesUrl = sliderContainer.findElements(By.className("label_text")).stream()
                .map(element -> element.getAttribute("href"))
                .collect(Collectors.toList());
        slidesUrl.forEach(System.out::println);

        for (int i = 0; i < slidesUrl.size(); i++) {
            WebElement currentSlide = getCurrentDriver().findElement(By.className("image"));
            String currentSlideUrl = currentSlide.getAttribute("href");
            try {
                Assert.assertEquals(slidesUrl.get(i), currentSlideUrl);
                new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(8))
                        .until(ExpectedConditions.not(ExpectedConditions.visibilityOf(currentSlide)));
            } catch (Exception e) {
                return false;
            }

        }
        return true;
    }
}
