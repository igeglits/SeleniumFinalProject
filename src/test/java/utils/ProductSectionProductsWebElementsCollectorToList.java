package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static utils.DriverProvider.getCurrentDriver;

public class ProductSectionProductsWebElementsCollectorToList {


    public List<String> collectAllProductsFromProductSectionReturnUrls(By productsListOnProductPage, By pagerOnProductPage) {
        List<WebElement> elementsFromFirstPageOfProductSection = getCurrentDriver().findElements(productsListOnProductPage);
        List<String> elementsUrl = getElementsUrl(elementsFromFirstPageOfProductSection);

        var pagerUrls = processPagerElementsAndExtractUrlsToList(pagerOnProductPage);

        for (String url : pagerUrls) {
            getCurrentDriver().get(url);
            List<WebElement> elementsFromNextPageOfProductSection = getCurrentDriver().findElements(productsListOnProductPage);
            List<String> nextPageElementsUrl = getElementsUrl(elementsFromNextPageOfProductSection);
            elementsUrl.addAll(nextPageElementsUrl);
        }

        return elementsUrl;
    }

    private List<String> processPagerElementsAndExtractUrlsToList(By pagerOnProductPage) {
        List<WebElement> notUniquePagerElements = getCurrentDriver().findElements(pagerOnProductPage);
        List<WebElement> uniquePagerElementsWithUrl = filterWebElementsForUniqueURL(notUniquePagerElements);

        return uniquePagerElementsWithUrl.stream()
                .map(element -> element.getAttribute("href"))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private static List<String> getElementsUrl(List<WebElement> elements) {
        List<String> elementsUrl;
        elementsUrl = elements.stream()
                .filter(element -> element.findElement(By.xpath(".//a[1]")) != null)
                .map(element -> element.findElement(By.xpath(".//a[1]")).getAttribute("href"))
                .collect(Collectors.toCollection(ArrayList::new));
        return elementsUrl;
    }

    public List<WebElement> filterWebElementsForUniqueURL(List<WebElement> list) {
        return new ArrayList<>(list.stream()
                .filter(e -> e.getAttribute("href") != null && e.getAttribute("href").startsWith("https"))
                .collect(Collectors.toMap(
                        e -> e.getAttribute("href"),  // Ключ: URL
                        e -> e,                       // Значение: сам элемент
                        (e1, e2) -> e1                // Разрешение коллизий: оставить первый элемент
                ))
                .values());
    }
}
