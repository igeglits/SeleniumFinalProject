package pages;

import org.openqa.selenium.By;

import java.io.IOException;

import static utils.CheckHttpStatus.getHttpStatusCode;
import static utils.DriverProvider.getCurrentDriver;

public class AyurvedicTeasPage extends BasePage {

    public static By productsListOnProductPageClassName = By.className("product-list");
    public static By pagerOnProductPage = By.className("paglm");

    private String pageUrl = "https://www.herbals.lv/en/Ayurveda-Ayurvedic-teas";

    public void open() throws IOException {
        if (getHttpStatusCode(pageUrl) == 200) {
            getCurrentDriver().get(pageUrl);
        }
    }
}
