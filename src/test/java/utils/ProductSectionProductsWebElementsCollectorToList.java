package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static utils.DriverProvider.getCurrentDriver;

public class ProductSectionProductsWebElementsCollectorToList {


    public List<String> collectAllProductsFromProductSectionReturnUrls(By productsListOnProductPage, By pagerOnProductPage) {
        List<String> elementsUrl = getElementsUrl(getCurrentDriver()
                .findElements(productsListOnProductPage));

        try {
            List<String> pagerUrls = processPagerElementsAndExtractUrlsToList(pagerOnProductPage);
            for (String url : pagerUrls) {
                getCurrentDriver().get(url);
                List<String> nextPageElementsUrl = getElementsUrl(getCurrentDriver()
                        .findElements(productsListOnProductPage));
                elementsUrl.addAll(nextPageElementsUrl);
            }
        } catch (Exception e) {
            return elementsUrl;
        }
        return elementsUrl;
    }

    private List<String> processPagerElementsAndExtractUrlsToList(By pagerOnProductPage) throws Exception {
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
                        e -> e,                       // Значение: элемент
                        (e1, e2) -> e1                // оставить первый элемент
                ))
                .values());
    }
}
