package edu.ucsd.app.qa.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProposalLookUpPage extends BasePage {

    private static final String PROPOSAL_NUMBER = "u19le2rl_control";
    private static final String SEARCH = "uuro6zu";
    private static final String NUMBER = "//*[@id=\'u16z0g9h_line0_control\']";
    private static final String CANCEL = "uuro6x9";
    private static final String CREATE_DATE = "ub8kwmtFrom_control";


    public void enterProposalNumber(WebDriver driver, String number) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PROPOSAL_NUMBER)));
        driver.findElement(By.id(PROPOSAL_NUMBER)).sendKeys(number);
    }

    public void enterCreateDate(WebDriver driver, String date) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CREATE_DATE)));
        driver.findElement(By.id(CREATE_DATE)).sendKeys(date);
    }

    public void clickSearch(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(SEARCH)));
        driver.findElement(By.id(SEARCH)).click();
    }

    public String getProposalNumber(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(NUMBER)));
        return driver.findElement(By.xpath(NUMBER)).getText();
    }

    public void clickCancel(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CANCEL)));
        Thread.sleep(3000);
        driver.findElement(By.id(CANCEL)).click();
    }
}
