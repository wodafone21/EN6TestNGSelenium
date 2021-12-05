package com.cybertek.tests.day7_TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.management.snmp.jvminstr.JvmOSImpl;

public class TestNG_Assertions_Demo {

    @Test
    public void test1() {

        System.out.println("Open Browser");

    }

    @Test
    public void test2() {

        System.out.println("First Assertion");
        Assert.assertEquals("title", "title");

        System.out.println("Second Assertion");
        Assert.assertEquals("url2", "url");

    }

    @Test
    public void test3() {
        String expectedTitle = "Cyb";
        String actualTitle = "Cybertek";

        Assert.assertTrue(actualTitle.startsWith(expectedTitle), "verify title starts with Cyb");
    }

    @Test
    public void test4() {
        //  verify email contains @ sign
        String email = "wodafone@hotmail.com";
        Assert.assertTrue(email.contains("@"), "verify email contains @");

    }

    @Test
    public void test5() {
        Assert.assertFalse(0 > 5, "verify that 0 is not greater than 5");

    }

     @Test
    public void test6 () {
        Assert.assertNotEquals("one", "two");

    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Close Browser");
    }
}
