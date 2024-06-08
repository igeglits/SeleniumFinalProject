package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static utils.DriverProvider.getCurrentDriver;

public class WebElementsCollectorToList {


    public List<WebElement> collectWebElementsWithUniqueURL(List<WebElement> list) {
        return new ArrayList<>(list.stream()
                .filter(e -> e.getAttribute("href") != null && e.getAttribute("href").startsWith("https"))
                .collect(Collectors.toMap(
                        e -> e.getAttribute("href"),  // Ключ: URL
                        e -> e,                       // Значение: сам элемент
                        (e1, e2) -> e1                // Разрешение коллизий: оставить первый элемент
                ))
                .values());
    }


    public List<String> collectAllProductsFromProductSection(By productsListOnProductPage, By pagerOnProductPage) {
        List<WebElement> elements = getCurrentDriver().findElements(productsListOnProductPage);
        List<String> elementsUrl = getElementsUrl(elements);

        List<WebElement> notUniquePagerElements = getCurrentDriver().findElements(pagerOnProductPage);
        List<WebElement> uniquePagerElementsWithUrl = collectWebElementsWithUniqueURL(notUniquePagerElements);
        List<String> urls = uniquePagerElementsWithUrl.stream()
                .map(element -> element.getAttribute("href"))
                .collect(Collectors.toCollection(ArrayList::new));

        for (String url : urls) {
            getCurrentDriver().get(url);
            List<WebElement> newPageElements = getCurrentDriver().findElements(productsListOnProductPage);
            List<String> newPageElementsUrl = getElementsUrl(newPageElements);
            elementsUrl.addAll(newPageElementsUrl);
        }

        return elementsUrl;
    }

    public static List<String> getElementsUrl(List<WebElement> elements) {
        List<String> elementsUrl;
        elementsUrl = elements.stream()
                .filter(element -> element.findElement(By.xpath(".//a[1]")) != null)
                .map(element -> element.findElement(By.xpath(".//a[1]")).getAttribute("href"))
                .collect(Collectors.toCollection(ArrayList::new));
        return elementsUrl;
    }
}
