package edu.ucsd.app.qa.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonTasksPage extends BasePage {

    private static final String SEARCH_PROPOSALS = "//*[@id=\'mainContent\']/div/div/div[6]/section/div/div[3]/a";

    public void clickSearchProposals(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SEARCH_PROPOSALS)));
        driver.findElement(By.xpath(SEARCH_PROPOSALS)).click();
    }


}
