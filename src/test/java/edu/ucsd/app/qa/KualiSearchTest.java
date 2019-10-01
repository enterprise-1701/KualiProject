package edu.ucsd.app.qa;

import edu.ucsd.app.qa.framework.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.Encryption;
import utility.ExcelUtil;
import utility.RetryCountIfFailed;

import java.util.logging.Logger;

public class KualiSearchTest {

    public static WebDriver driver;
    final static Logger logger = Logger.getLogger(KualiSearchTest.class.getName());

    @BeforeMethod
    public void beforeMethod() throws Exception {

        //Gecko driver
        System.setProperty(AppConstant.GECKO_DRIVER, System.getProperty("user.dir") + AppConstant.GECKO_DRIVER_LOCATION);
        driver = new FirefoxDriver();

        //Chrome driver
        //System.setProperty(AppConstant.CHROME_DRIVER, System.getProperty("user.dir") + AppConstant.CHROME_DRIVER_LOCATION);
        //driver = new ChromeDriver();

    }

    @DataProvider(name = "Authentication")
    public Object[][] Authentication() throws Exception {
        ExcelUtil readExcelFile = new ExcelUtil();
        String filePath = System.getProperty("user.dir") + AppConstant.INPUT_PATH;
        Object[][] testObjArray = readExcelFile.readExcel(filePath, AppConstant.INPUT_FILE, AppConstant.INPUT_SHEET);
        return (testObjArray);
    }

    @Test(dataProvider = "Authentication")
    @RetryCountIfFailed(3)
    public static void searchTest(String sUsername, String sPassword, String sData, String sTestresults) throws Exception {

        logger.info("Starting Test Script");
        LoginPage loginPage = new LoginPage();
        loginPage.getLandingPage(driver);
        loginPage.enterUsername(driver, sUsername);
        loginPage.enterPassword(driver, Encryption.decodeString(sPassword));
        loginPage.clickLogin(driver);
        LandingPage landingPage = new LandingPage();
        landingPage.clickResearchHome(driver);
        DashBoardPage dashBoardPage = new DashBoardPage();
        dashBoardPage.clickCommonTasks(driver);
        CommonTasksPage commonTasksPage = new CommonTasksPage();
        commonTasksPage.clickSearchProposals(driver);
        commonTasksPage.switchToFrame(driver);
        ProposalLookUpPage proposalLookUpPage = new ProposalLookUpPage();
        proposalLookUpPage.enterCreateDate(driver, sData);
        proposalLookUpPage.clickSearch(driver);
        Assert.assertEquals(proposalLookUpPage.getProposalNumber(driver), sTestresults);
        proposalLookUpPage.clickCancel(driver);
        proposalLookUpPage.switchToMain(driver);
        dashBoardPage.clickCommonTasks(driver);
        dashBoardPage.clickLogOut(driver);
    }

    @AfterMethod
    public void afterMethod() {
        logger.info("Closing browser");
        driver.close();
    }
}