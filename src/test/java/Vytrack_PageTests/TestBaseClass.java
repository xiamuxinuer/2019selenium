package Vytrack_PageTests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Browserutils;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ExcelUtils;

import java.io.IOException;

public  abstract class TestBaseClass {
    //will be visible in the subclass, regardless on subclass location (same package or no)
    protected WebDriverWait wait;
    protected Actions actions;
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;
    protected static int row = 1;
    protected ExcelUtils excelUtil;

    //@Optional - to make parameter optional
    //if you don't specify it, testng will require to specify this parameter for every test, in xml runner
    @BeforeTest
    @Parameters("reportName")
    public void setupTest(@Optional String reportName) {
        System.out.println("Report name: " + reportName);
        reportName = reportName == null ? "report.html" : reportName + ".html";
        report = new ExtentReports();
        String reportPath = "";
        //location of report file
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            reportPath = System.getProperty("user.dir") + "\\test-output\\" + reportName;
        } else {
            reportPath = System.getProperty("user.dir") + "/test-output/" + reportName;
        }
        //is a HTML report itself
        htmlReporter = new ExtentHtmlReporter(reportPath);
        //add it to the reporter
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("VYTRACK Test Automation Results");
    }
    @AfterTest
    public void afterTest() {
        report.flush();//to release a report
    }
    @BeforeMethod
    public void setup() {
        String URL = ConfigurationReader.getProperty("qa3");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), 25);
        actions = new Actions(Driver.getDriver());
    }
    @AfterMethod
    public void teardown(ITestResult iTestResult) throws IOException {
        //ITestResult class describes the result of a test.
        //if test failed, take a screenshot
        //no failure - no screenshot
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            //screenshot will have a name of the test
            String screenshotPath = Browserutils.getScreenshot(iTestResult.getName());
            test.fail(iTestResult.getName());//attach test name that failed
            Browserutils.wait(2);
            test.addScreenCaptureFromPath(screenshotPath, "Failed");//attach screenshot
            test.fail(iTestResult.getThrowable());//attach console output
            //if excelUtil object was created
            //set value if result column to failed
            if (excelUtil != null) {
                excelUtil.setCellData("FAILED", "result", row++);
            }
        }
        Browserutils.wait(2);
        Driver.closeDriver();
    }

}
