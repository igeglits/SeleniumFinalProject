package utils;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

import static Config.Config.HTTP_CODE;
import static utils.CheckHttpStatus.getHttpStatusCode;

public class AssertionUtils {

    public static void assertEqualsStrings(String actual, String expected) {
        Reporter.log("We are validating whether 2 strings are equals: " + actual + " and" + expected);
        Assert.assertEquals(actual, expected);
    }

    public static void assertLinkRespondWithStatus200(List<String> elements) throws IOException {
        SoftAssert softAssert = new SoftAssert();
        for (String link : elements) {
            int actualStatusCode = getHttpStatusCode(link);
            Reporter.log("For " + link + " received code " + actualStatusCode);
            softAssert.assertEquals(actualStatusCode, HTTP_CODE);
        }
        softAssert.assertAll();
    }
}