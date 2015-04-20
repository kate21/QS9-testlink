package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import models.TestSuite;

/**
 * Created by Admin on 20.04.2015.
 */
public class TestSuiteEditPage{

    private WebDriver driver;

    private static final By nameField = By.id("name");
    private static final By saveButton = By.name("add_testsuite_button");

    public TestSuiteEditPage(WebDriver driver)  {
        this.driver = driver;
    }

    public void editTestSuite(TestSuite testSuite) {
        driver.findElement(nameField).sendKeys(testSuite.suiteName);
        driver.findElement(saveButton).click();
    }
}