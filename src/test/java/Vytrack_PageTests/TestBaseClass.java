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

import java.io.IOException;

public  abstract class TestBaseClass {
    protected WebDriverWait wait;
    protected Actions actions;
    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;


@BeforeTest
@Parameters("reportName")
public void beforeTest(@Optional String reportName){
    System.out.printf("report name "+ reportName);
    report =new ExtentReports();

    String reportPath= System.getProperty("user.dir")+"/test-output/report.html";
    htmlReporter=new ExtentHtmlReporter(reportPath);
    report.attachReporter(htmlReporter);
    htmlReporter.config().setReportName("Vytrack  Test Automation Result");
}
@AfterTest
public void afterTest(){
    report.flush();// to release report
}



    @BeforeMethod
    public void setUp(){
        String url= ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(url);
        Driver.getDriver().manage().window().maximize();
        wait=new WebDriverWait(Driver.getDriver(),15);
        actions=new Actions(Driver.getDriver());
    }

     @AfterMethod
    public void tearDown(ITestResult iTestResult) throws IOException {
        if (iTestResult.getStatus()==ITestResult.FAILURE){
            //take screen shot:
            String screenshotPath =Browserutils.getScreenshot(iTestResult.getName());
            //we can put some wait here;
            Browserutils.waitForPageToLoad(5);

            test.addScreenCaptureFromPath(screenshotPath);// attach screen shot
            test.fail(iTestResult.getName());//attach test name that failed
            test.fail(iTestResult.getThrowable());// attach console output
        }

        Driver.closeDriver();
     }

}
