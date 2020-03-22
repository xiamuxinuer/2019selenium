package Day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.DriverFactory;

import java.util.concurrent.TimeUnit;

public class explicitWaitPractice {
    WebDriver driver;
    WebDriverWait wait;


    @BeforeMethod
    public void setUp(){
        driver= DriverFactory.createDriver("chrome");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void waitForTitle(){
        driver.get("http://google.com");
        WebDriverWait wait= new WebDriverWait(driver,10);
        //wait up to 10 seconds until title is google:
        wait.until(ExpectedConditions.titleIs("Google"));
        driver.navigate().to("http://amazon.com");
        wait.until(ExpectedConditions.titleContains("Amazon"));

    }

}
