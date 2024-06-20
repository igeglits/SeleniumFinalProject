package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static utils.DriverProvider.getCurrentDriver;

public class ProductSectionProductsUrlsCollectorToList {


    public List<String> collectAllProductsFromProductSectionReturnUrls(By productsListOnProductPage, By pagerOnProductPage) {
        List<String> elementsUrl = collectProductsUrlsFromFirstProductPage(productsListOnProductPage);
        ifProductListHasPaginatorCollectProductsUrlFromPagesAndAddToUrlslist(productsListOnProductPage, pagerOnProductPage, elementsUrl);
        return elementsUrl;
    }

    private List<String> collectProductsUrlsFromFirstProductPage(By productsListOnProductPage) {
        return getElementsUrl(getCurrentDriver()
                .findElements(productsListOnProductPage));
    }

    private static List<String> getElementsUrl(List<WebElement> elements) {
        List<String> elementsUrl;
        elementsUrl = elements.stream()
                .filter(element -> element.findElement(By.xpath(".//a[1]")) != null)
                .map(element -> element.findElement(By.xpath(".//a[1]")).getAttribute("href"))
                .collect(Collectors.toCollection(ArrayList::new));
        return elementsUrl;
    }

    private boolean ifProductListHasPaginatorCollectProductsUrlFromPagesAndAddToUrlslist(By productsListOnProductPage, By pagerOnProductPage, List<String> elementsUrl) {
        try {
            List<String> pagerUrls = processPagerElementsAndExtractPagesUrlsToList(pagerOnProductPage);
            getProductsUrlsFromPaginatorPages(elementsUrl, pagerUrls, productsListOnProductPage);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private List<String> processPagerElementsAndExtractPagesUrlsToList(By pagerOnProductPage) throws Exception {
        List<WebElement> notUniquePagerElements = getCurrentDriver().findElements(pagerOnProductPage);
        List<WebElement> uniquePagerElementsWithUrl = filterWebElementsForUniqueURL(notUniquePagerElements);

        return uniquePagerElementsWithUrl.stream()
                .map(element -> element.getAttribute("href"))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<WebElement> filterWebElementsForUniqueURL(List<WebElement> list) {
        return new ArrayList<>(list.stream()
                .filter(e -> e.getAttribute("href") != null && e.getAttribute("href").startsWith("https"))
                .collect(Collectors.toMap(
                        e -> e.getAttribute("href"),  // Ключ: URL
                        e -> e,                       // Значение: элемент
                        (e1, e2) -> e1                // оставить первый элемент
                ))
                .values());
    }
    private List<String> getProductsUrlsFromPaginatorPages(List<String> elementsUrl, List<String> pagerUrls, By productsListOnProductPage) {
        for (String url : pagerUrls) {
            getCurrentDriver().get(url);
            List<String> nextPageElementsUrl = getElementsUrl(getCurrentDriver()
                    .findElements(productsListOnProductPage));
            elementsUrl.addAll(nextPageElementsUrl);
        }
        return elementsUrl;
    }
}
