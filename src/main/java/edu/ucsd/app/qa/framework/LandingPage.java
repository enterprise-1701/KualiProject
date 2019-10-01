package edu.ucsd.app.qa.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BasePage {

    private static final String USERS = "/html/body/div/div/div[2]/div[2]/div[1]/div/ul/li[4]/div[2]";
    private static final String RESEARCH_HOME = "//*[@id='mainContent']/div[1]/div/ul/li[1]/div[2]";

    public void clickUsers(WebDriver driver) {
        driver.findElement(By.xpath(USERS)).click();
    }

    public void clickResearchHome(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(RESEARCH_HOME)));
        driver.findElement(By.xpath(RESEARCH_HOME)).click();
    }

}
