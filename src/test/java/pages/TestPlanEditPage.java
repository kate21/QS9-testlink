package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import models.TestPlan;

/**
 * Created by admin on 08.04.2015.
 */
public class TestPlanEditPage {

    private WebDriver driver;

    private static final By nameField = By.name("testplan_name");
    private static final By descriptionField = By.xpath("/html/body");
    private static final By activeCheckBox = By.name("active");
    private static final By isPublicCheckBox = By.name("is_public");
    private static final By createButton = By.name("do_create");

    public TestPlanEditPage(WebDriver driver) {
        this.driver = driver;
    }


    public void createTestPlan(TestPlan testPlan) {
        driver.findElement(nameField).sendKeys(testPlan.name);
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='cke_contents_notes']/iframe")));
        driver.findElement(descriptionField).sendKeys(testPlan.description);
        driver.switchTo().defaultContent().switchTo().frame("mainframe");
        if (testPlan.active)
            driver.findElement(activeCheckBox).click();
        if (testPlan.pub)
            driver.findElement(isPublicCheckBox).click();
        driver.findElement(createButton).click();
    }
}
