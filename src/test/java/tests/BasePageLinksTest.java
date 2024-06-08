package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static utils.AssertionUtils.assertEqualsForLinkRespondStatus200;
import static utils.DriverProvider.getCurrentDriver;
import static utils.WebElementsCollectorToList.getElementsUrl;

public class BasePageLinksTest extends BaseTest {

    @Test
    void checkAllLinksOnPageForStatus200() throws IOException {
        List<WebElement> elementsWithUrl = getCurrentDriver().findElements(By.xpath("//a[starts-with(@href, 'https')]"));
        List<String> links = elementsWithUrl.stream()
                        .map(e -> e.getAttribute("href"))
                                .toList();
        assertEqualsForLinkRespondStatus200(links);
    }
}
