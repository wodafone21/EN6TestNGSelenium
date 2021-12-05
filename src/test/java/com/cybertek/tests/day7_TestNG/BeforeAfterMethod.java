package com.cybertek.tests.day7_TestNG;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    @BeforeClass
    public void setingUp () {
        System.out.println("----BEFORE CLASS----");

    }

    @Test
    public void test1() {

        System.out.println("First Test Case");

    }

    @Ignore // this test case will be ignored
    @Test
    public void test2() {
        System.out.println("Second Test Case");

    }

    @Test
    public void test3() {
        System.out.println("Third Test Case");

    }

    @BeforeMethod
    public void setUp() {
        System.out.println("---BEFORE METHOD----");
        System.out.println("WebDriver, Opening Browser");
    }

    @AfterMethod
    public void tearDown () {
        System.out.println("---AFTER METHOD---");
        System.out.println("Closing Browser, Quit");
    }

    @AfterClass
    public void tearingDown () {
        System.out.println("----AFTER CLASS----");
    }
}
