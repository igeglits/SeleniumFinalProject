package utils;

import org.testng.Assert;
import org.testng.Reporter;

public class AssertionUtils {

    public static void assertEqualsStrings(String actual, String expected) {
        Reporter.log("We are validating whether 2 strings are equals: " + actual + " and" + expected);
        Assert.assertEquals(actual, expected);
    }

    public static void assertEqualsForRespondStatus200(String link, int actual) {
        Reporter.log("For link " + link + " received code " + actual);
        Assert.assertEquals(actual, 200);
    }
}
