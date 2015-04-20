package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import models.User;


/**
 * Created by admin on 08.04.2015.
 */
public class TestPlanLoginPage {

    private WebDriver driver;

    private static final String URL = "http://demo.testlink.org/latest/login.php";

    private static final By loginField = By.id("login");
    private static final By PassField = By.name("tl_password");
    private static final By loginButton = By.name("login_submit");

    public TestPlanLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(User user) {
        driver.get(URL);
        driver.findElement(loginField).clear();
        driver.findElement(loginField).sendKeys(user.name);
        driver.findElement(PassField).clear();
        driver.findElement(PassField).sendKeys(user.pass);
        driver.findElement(loginButton).click();
    }
}
