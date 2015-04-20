package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by admin on 08.04.2015.
 */

public class HomePage {

    private WebDriver driver;

    private static final By TestPlanManagementLink = By.xpath("//*[@id='test_plan_mgmt_topics']/a[1]");
    private static final By Logout = By.xpath("//img[contains(@src,'gui/themes/default/images/computer_go.png')]");
    private static final By testSuiteManagementLink = By.xpath("//*[@id='testspecification_topics']/a[1]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }



    public TestPlanManagementPage openTestManagement() {
        driver.switchTo().frame("mainframe").findElement(TestPlanManagementLink).click();
        return new TestPlanManagementPage(driver);
    }
    public void logout() {
        driver.switchTo().frame("titlebar");
        driver.findElement(Logout).click();
    }

    public TestSuiteManagementPage openTestSpecification() {
        Frames.switchToMainFrame(driver);
        driver.findElement(testSuiteManagementLink).click();
        return new TestSuiteManagementPage(driver);
    }

}
