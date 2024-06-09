package tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import static utils.DriverProvider.closeDriver;
import static utils.DriverProvider.getCurrentDriver;


public class BaseTest {

    WebDriverWait wait;

    @BeforeMethod
    void setUp() {

        wait = new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(2));
        getCurrentDriver().manage().window().maximize();
        getCurrentDriver().get("https://www.herbals.lv/en/");

    }

    @AfterMethod
    void tearDown() {
        closeDriver();
    }
}
