package utils;

import org.testng.Assert;
import org.testng.Reporter;

public class AssertionUtils {

    public static void assertEquals(String actual, String expected){
        Reporter.log("We are validating whether 2 strings are equals: " + actual + " and" + expected);
        Assert.assertEquals(actual, expected);
    }
}
