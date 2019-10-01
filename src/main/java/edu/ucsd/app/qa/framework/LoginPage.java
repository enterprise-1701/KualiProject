package edu.ucsd.app.qa.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private static final String USER_FIELD = "//*[@id='username']";
    private static final String PW_FIELD = "//*[@id='password']";
    private static final String LOGIN = "//*[@id=\'login\']";

    public void getLandingPage(WebDriver driver) {
        driver.get(AppConstant.LOGIN_PAGE);
    }

    public void enterUsername(WebDriver driver, String userName) {
        driver.findElement(By.xpath(USER_FIELD)).sendKeys(userName);
    }

    public void enterPassword(WebDriver driver, String passWord) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PW_FIELD)));
        driver.findElement(By.xpath(PW_FIELD)).sendKeys(passWord);
    }

    public void clickLogin(WebDriver driver) {
        driver.findElement(By.xpath(LOGIN)).click();
    }

}
