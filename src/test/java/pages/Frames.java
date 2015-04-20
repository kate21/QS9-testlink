package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Admin on 20.04.2015.
 */
public class Frames {

    public static void switchToMainFrame(WebDriver driver) {
        driver.switchTo().frame("mainframe");
    }

    public static void switchToTitleBar(WebDriver driver) {
        driver.switchTo().frame("titlebar");
    }

    public static void switchToDefault(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public static void switchToWorkFrame(WebDriver driver) { driver.switchTo().frame("workframe"); }

    public static void switchToTreeFrame(WebDriver driver) { driver.switchTo().frame("treeframe"); }

    public static void switchToParentFrame(WebDriver driver) { driver.switchTo().parentFrame(); }


}