package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static utils.AssertionUtils.assertEqualsForRespondStatus200;
import static utils.CheckHttpStatus.getHttpStatusCode;
import static utils.DriverProvider.getCurrentDriver;

public class BasePageLinksTest extends BaseTest {

    @Test
    void getLinksListAndLinkCheckFor200() throws IOException {
        List<WebElement> links = getCurrentDriver().findElements(By.xpath("//a[starts-with(@href, 'https')]"));
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            int actualStatusCode = getHttpStatusCode(url);
            assertEqualsForRespondStatus200(String.valueOf(link), actualStatusCode);
        }
    }
}
