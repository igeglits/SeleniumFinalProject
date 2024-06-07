package dataProviders;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

public class BasePageDataProvider {

    @DataProvider
    public Object[] pageBlocksIds() {
        return new Object[]{
                By.id("topWrap"),
                By.id("box_skitter_large_wrap"),
                By.id("mainCentered")
        };
    }
}
