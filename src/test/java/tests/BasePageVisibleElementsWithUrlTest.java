package tests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.BasePage;

import java.io.IOException;

import static utils.AssertionUtils.assertLinkRespondWithStatus200;
@Ignore
public class BasePageVisibleElementsWithUrlTest extends BaseTest {

    @Test
    void checkAllVisibleElementsWithUrlOnPageForStatus200() throws IOException {
        BasePage basePage = new BasePage();

        assertLinkRespondWithStatus200(basePage.getLinkFromWebElement(
                basePage.collectVisibleElementsWithUrlToList()));
    }
}
