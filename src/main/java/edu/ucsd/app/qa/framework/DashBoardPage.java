package edu.ucsd.app.qa.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage extends BasePage {

    private static final String COMMON_TASKS = "//*[@id=\'root\']/div/div[2]/aside/ul[1]/ul/div[3]/div/a/i";
    private static final String LOGOUT = "/html/body/div/div/div[2]/aside/ul[2]/ul/div[3]/div/a/span";

    public void clickCommonTasks(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(COMMON_TASKS)));
        driver.findElement(By.xpath(COMMON_TASKS)).click();
    }

    public void clickLogOut(WebDriver driver) {
        driver.findElement(By.xpath(LOGOUT));
    }
}
