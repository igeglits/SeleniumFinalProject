package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static utils.DriverProvider.closeDriver;
import static utils.DriverProvider.getCurrentDriver;


public class BaseTest {


    @BeforeMethod
    void setUp() {
        getCurrentDriver().manage().window().maximize();
        getCurrentDriver().get("https://www.herbals.lv/en/");
    }

    @AfterMethod
    void tearDown() {
        closeDriver();
    }
}
