package Day11;

import Day9.JSExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Browserutils;
import utilities.DriverFactory;

public class JSExecutorPractice {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver= DriverFactory.createDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }



@AfterMethod
    public void tearDown(){
        driver.quit();
}

@Test
    public void verifyTiTile() throws InterruptedException {
    JavascriptExecutor js= (JavascriptExecutor) driver;

    String actualTitle=  js.executeScript("return document.title").toString();
    String expected="Practice";
    Assert.assertEquals(actualTitle,expected);
    Thread.sleep(3000);
}

@Test
    public void clickButton() throws InterruptedException {
        //driver.findElement(By.linkText("Multiple Buttons")).click();
 //or: use js
    JavascriptExecutor js= (JavascriptExecutor) driver;
    WebElement element=driver.findElement(By.linkText("Multiple Buttons"));
    js.executeScript("arguments[0].click()",element);

    Thread.sleep(3000);
    WebElement disappearButton=driver.findElement(By.id("disappearing_button"));
    js.executeScript("arguments[0].click()",disappearButton);
    Thread.sleep(3000);
    WebElement result=driver.findElement(By.id("result"));
    Assert.assertEquals(result.getText(),"Now it's gone!");
}

@Test
    public void inputTest() throws InterruptedException {
        driver.findElement(By.linkText("Form Authentication")).click();
        Thread.sleep(3000);
    WebElement userName=driver.findElement(By.name("username"));
    WebElement passWord=driver.findElement(By.name("password"));
    WebElement login=driver.findElement(By.id("wooden_spoon"));


    JavascriptExecutor js= (JavascriptExecutor) driver;
    js.executeScript("arguments[0].setAttribute('value','tomsmith')",userName);
    js.executeScript("arguments[0].setAttribute('value','SuperSecretPassword')",passWord);
    js.executeScript("arguments[0].click()",login);
    String expected="Welcome to the Secure Area. When you are done click logout below.";
    String actual=driver.findElement(By.tagName("h4")).getText();
    Assert.assertEquals(actual,expected);
}


@Test
    public void ScrollPage() throws InterruptedException {
    Thread.sleep(3000);
    JavascriptExecutor js= (JavascriptExecutor) driver;
    WebElement link= driver.findElement(By.linkText("Cybertek School"));
    js.executeScript("arguments[0].scrollIntoView(true)",link);
    Thread.sleep(3000);
    link.click();
    Thread.sleep(3000);
}








}

