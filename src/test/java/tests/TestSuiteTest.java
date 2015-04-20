package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import models.*;
import pages.*;


import java.util.concurrent.TimeUnit;

/**
 * Created by Admin on 20.04.2015.
 */
public class TestSuiteTest {
    WebDriver driver;
    TestSuite testSuite = new TestSuite();
    TestCase testCase = new TestCase();
    TestSteps testStep = new TestSteps();
    TestSuiteManagementPage testSuiteManagementPage;
    TestSuiteEditPage testSuiteEditPage;
    TestCaseEditPage testCaseEditPage;

    @BeforeTest
    public void userLogin() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        TestPlanLoginPage loginPage = new TestPlanLoginPage(driver);
        loginPage.login(new User());
    }

    @Test
    public void TestSuiteTest() {
        createTestSuite();
        Assert.assertTrue(testSuiteManagementPage.isTestSuitePresent(testSuite));
        createTestCase();
        Assert.assertTrue(testSuiteManagementPage.isTestCasePresent(testCase, testSuite));
        addTestStep();
        deleteTestSuite(testSuite);
    }

    @AfterTest
    public void shutEnv() {
        if (driver != null)
            driver.quit();
    }

    public void createTestSuite() {
        HomePage homePage = new HomePage(driver);

        testSuiteManagementPage = homePage.openTestSpecification();
        testSuiteEditPage = testSuiteManagementPage.createNewTestSuite();
        testSuiteEditPage.editTestSuite(testSuite);
    }

    public void createTestCase() {
        testCaseEditPage = testSuiteManagementPage.createTestCase(testSuite);
        testCaseEditPage.editTestCase(testCase);
    }

    public void addTestStep() {
        testCaseEditPage.createNewStep(testCase, testSuite);
        testCaseEditPage.addStep(testStep);
    }

    public void deleteTestSuite(TestSuite testSuite) {
        TestSuiteManagementPage testSuiteManagementPage = new TestSuiteManagementPage(driver);
        testSuiteManagementPage.deleteTestSuite(testSuite);
    }
}
