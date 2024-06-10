package tests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.BasePage;
import utils.ProductSectionProductsWebElementsCollectorToList;

import java.io.IOException;
import java.util.List;

import static pages.AyurvedicTeasPage.pagerOnProductPage;
import static pages.AyurvedicTeasPage.productsListOnProductPageClassName;
import static utils.AssertionUtils.assertEqualsForLinkRespondStatus200;

public class AyurvedicTeasPageTest extends BaseTest {

    @Test
    void checkAllProductsLinksInProductSectionInclPagingForStatus200() throws IOException {
        var basePage = new BasePage();

        basePage.openAyurvedicTeaPage();

        List<String> productsUrls = new ProductSectionProductsWebElementsCollectorToList().collectAllProductsFromProductSectionReturnUrls(
                productsListOnProductPageClassName,
                pagerOnProductPage);

        assertEqualsForLinkRespondStatus200(productsUrls);
    }
}
