package tests;

import org.testng.annotations.Test;
import pages.BasePage;
import utils.ProductSectionProductsUrlsCollectorToList;

import java.io.IOException;
import java.util.List;

import static pages.AyurvedicTeasPage.pagerOnProductPage;
import static pages.AyurvedicTeasPage.productsListOnProductPageClassName;
import static utils.AssertionUtils.assertLinkRespondWithStatus200;

public class ForWomanProductLinksTest extends BaseTest{

    @Test
    void checkAllForWomenProductsLinksForCode200 () throws IOException {
        var basePage = new BasePage();
        basePage.openForWomanPage();

        List<String> urls = new ProductSectionProductsUrlsCollectorToList()
                .collectAllProductsFromProductSectionReturnUrls(
                        productsListOnProductPageClassName,
                        pagerOnProductPage);

        assertLinkRespondWithStatus200(urls);
    }
}
