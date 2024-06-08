package pages;

import java.io.IOException;

import static utils.CheckHttpStatus.getHttpStatusCode;
import static utils.DriverProvider.getCurrentDriver;

public class AyurvedicTeasPage extends BasePage {
    private String pageUrl = "https://www.herbals.lv/en/Ayurveda-Ayurvedic-teas";

    public void open() throws IOException {
        if (getHttpStatusCode(pageUrl) == 200) {
            getCurrentDriver().get(pageUrl);
        }
    }
}
