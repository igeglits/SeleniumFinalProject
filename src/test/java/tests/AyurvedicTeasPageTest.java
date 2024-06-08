package tests;

import org.testng.annotations.Test;
import pages.AyurvedicTeasPage;
import utils.ProductSectionProductsWebElementsCollectorToList;

import java.io.IOException;
import java.util.List;

import static pages.AyurvedicTeasPage.pagerOnProductPage;
import static pages.AyurvedicTeasPage.productsListOnProductPageClassName;
import static utils.AssertionUtils.assertEqualsForLinkRespondStatus200;

public class AyurvedicTeasPageTest extends BaseTest {

    @Test
    void checkAllProductsLinksForStatus200() throws IOException, InterruptedException {
        var AyurvedicTeaPage = new AyurvedicTeasPage();
        var elementsCollectorToList = new ProductSectionProductsWebElementsCollectorToList();

        AyurvedicTeaPage.open();
        List<String> productsUrls = elementsCollectorToList.collectAllProductsFromProductSectionReturnUrls(
                productsListOnProductPageClassName,
                pagerOnProductPage);

        assertEqualsForLinkRespondStatus200(productsUrls);
    }
}
