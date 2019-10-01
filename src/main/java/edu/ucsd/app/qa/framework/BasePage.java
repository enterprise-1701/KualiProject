package edu.ucsd.app.qa.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private static final String IFRAME = "iframeportlet";

    public void switchToFrame(WebDriver driver) {
        driver.switchTo().frame(driver.findElement(By.id(IFRAME)));
    }

    public void switchToMain(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

}
