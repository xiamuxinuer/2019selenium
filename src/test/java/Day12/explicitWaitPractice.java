package Day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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

    @Test
    public void  visibilityTest(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.findElement(By.tagName("button")).click();
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
        wait.until(ExpectedConditions.visibilityOf(username)).sendKeys("tomsmith");
        wait.until(ExpectedConditions.visibilityOf(password)).sendKeys("SuperSecretPassword");
        wait.until(ExpectedConditions.visibilityOf(submitBtn));
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();
        Assert.assertEquals(actual, expected);
    }

@Test
    public void elementToBeClickable()  {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/5");
        WebDriverWait wait=new WebDriverWait(driver,15);
        WebElement username=driver.findElement(By.id("username"));
        WebElement password=driver.findElement(By.name("password"));
        WebElement submitButton=driver.findElement(By.cssSelector("button[type='submit']"));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loadingoverlay")));

        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword");

        submitButton.click();

    String expected = "Welcome to the Secure Area. When you are done click logout below.";
    String actual = driver.findElement(By.className("subheader")).getText();
    Assert.assertEquals(actual, expected);
}






}







