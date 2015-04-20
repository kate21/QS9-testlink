package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import models.TestCase;
import models.TestSuite;

/**
 * Created by Admin on 20.04.2015.
 */
public class TestSuiteManagementPage {

    private WebDriver driver;

    private static final By actions = By.xpath("//*[@class='workBack']/img[@title='Actions']");
    private static final By newTestSuiteBtn = By.id("new_testsuite");
    private static final By newTestCaseBtn = By.id("create_tc");
    private static final By deleteTestSuiteBtn = By.id("delete_testsuite");
    private static final By confirmBtn = By.name("delete_testsuite");
    public static final String testSuitePath = "//ul[@class='x-tree-node-ct']//*[contains(text(), '%s')]";
    private static final String xpandBtnPath = "//ul[@class='x-tree-node-ct']//*[contains(text(), '%s')]/ancestor::div/img[@class='x-tree-ec-icon x-tree-elbow-end-plus']";
    private static final String testCasePath = "//*[contains(text(), '%s')]";

    public TestSuiteManagementPage(WebDriver driver) {
        this.driver = driver;
    }

    public TestSuiteEditPage createNewTestSuite() {
        Frames.switchToWorkFrame(driver);
        driver.findElement(actions).click();
        driver.findElement(newTestSuiteBtn).click();
        return new TestSuiteEditPage(driver);
    }

    public boolean isTestSuitePresent(TestSuite testSuite) {
        By testSuiteLink = By.xpath(String.format(testSuitePath, testSuite.suiteName));
        Frames.switchToParentFrame(driver);
        Frames.switchToTreeFrame(driver);
        return driver.findElements(testSuiteLink).size() != 0;
    }

    public TestCaseEditPage createTestCase(TestSuite testSuite) {
        By testSuiteLink = By.xpath(String.format(testSuitePath, testSuite.suiteName));
        driver.findElement(testSuiteLink).click();
        Frames.switchToParentFrame(driver);
        Frames.switchToWorkFrame(driver);
        driver.findElement(actions).click();
        driver.findElement(newTestCaseBtn).click();
        return new TestCaseEditPage(driver);
    }

    public boolean isTestCasePresent(TestCase testCase, TestSuite testSuite) {
        By xpandButton = By.xpath(String.format(xpandBtnPath, testSuite.suiteName));
        By testCaseLink = By.xpath(String.format(testCasePath, testCase.caseTitle));
        Frames.switchToParentFrame(driver);
        Frames.switchToTreeFrame(driver);
        driver.findElement(xpandButton).click();
        return driver.findElements(testCaseLink).size() != 0;
    }

    public void deleteTestSuite(TestSuite testSuite) {
        By testSuiteLink = By.xpath(String.format(testSuitePath, testSuite.suiteName));
        Frames.switchToParentFrame(driver);
        Frames.switchToTreeFrame(driver);
        driver.findElement(testSuiteLink).click();
        Frames.switchToParentFrame(driver);
        Frames.switchToWorkFrame(driver);
        driver.findElement(actions).click();
        driver.findElement(deleteTestSuiteBtn).click();
        driver.findElement(confirmBtn).click();
    }
}
