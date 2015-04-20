package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import models.TestPlan;

/**
 * Created by admin on 08.04.2015.
 */
public class TestPlanManagementPage {

    private WebDriver driver;

    private static final By createButton = By.name("create_testplan");

    public TestPlanManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    public TestPlanEditPage createTestPlan() {
        driver.findElement(createButton).click();
        return new TestPlanEditPage(driver);
    }

    public boolean isTestPlanPresent(TestPlan testPlan) {
        return driver.findElement(By.linkText(testPlan.name)) != null;
    }



    public void deleteTestPlan(TestPlan testPlan) {
        if (driver.findElement(By.linkText(testPlan.name)) != null) {
            driver.findElement(By.xpath("/html/body/div/div[1]/form/table/tbody/tr[112]/td[8]/img")).click();
            driver.findElement(By.id("ext-gen20")).click();
        }
    }
}
