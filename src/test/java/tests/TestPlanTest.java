package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import models.TestPlan;
import models.User;
import pages.HomePage;
import pages.TestPlanEditPage;
import pages.TestPlanLoginPage;
import pages.TestPlanManagementPage;


import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 08.04.2015.
 */
public class TestPlanTest {

    WebDriver driver;

    @BeforeTest
    public void userLogin() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        TestPlanLoginPage testPlanLoginPage = new TestPlanLoginPage(driver);
        testPlanLoginPage.login(new User());
    }

    @Test
    public void positiveTestPlanTest() {
        HomePage homepage = new HomePage(driver);

        TestPlanManagementPage testPlanManagementPage = homepage.openTestManagement();
        TestPlanEditPage testPlanEditPage = testPlanManagementPage.createTestPlan();

        TestPlan testPlan = new TestPlan();
        testPlanEditPage.createTestPlan(testPlan);

        Assert.assertTrue(testPlanManagementPage.isTestPlanPresent(testPlan));
        deleteTestPlan(testPlan);
    }

    @AfterTest

    public void shutEnv() {
        if (driver != null)
            driver.quit();
    }

    public void deleteTestPlan(TestPlan testPlan) {
        TestPlanManagementPage testPlanManagementPage = new TestPlanManagementPage(driver);
        testPlanManagementPage.deleteTestPlan(testPlan);
    }

}
