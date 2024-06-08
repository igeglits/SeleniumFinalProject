package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.AyurvedicTeasPage;
import utils.WebElementsCollectorToList;

import java.io.IOException;
import java.util.List;

import static pages.BasePage.pagerOnProductPage;
import static pages.BasePage.productsListOnProductPageClassName;
import static utils.AssertionUtils.assertEqualsForLinkRespondStatus200;

public class AyurvedicTeasPageTest extends BaseTest {

    @Test
    void checkProductAllLinksForStatus200() throws IOException, InterruptedException {
        AyurvedicTeasPage page = new AyurvedicTeasPage();
        WebElementsCollectorToList collector = new WebElementsCollectorToList();

        page.open();
        List<String> productsUrls = collector
                .collectAllProductsFromProductSection(
                        productsListOnProductPageClassName,
                        pagerOnProductPage);

        assertEqualsForLinkRespondStatus200(productsUrls);
    }
}
