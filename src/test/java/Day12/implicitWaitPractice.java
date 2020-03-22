package Day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.DriverFactory;

import java.util.concurrent.TimeUnit;

public class implicitWaitPractice {
   WebDriver driver;

    @BeforeMethod
    public void setUp(){
         driver= DriverFactory.createDriver("chrome");
         driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
@AfterMethod
    public void tearDown(){
        driver.quit();
}

@Test
    public void waitTest(){
        driver.findElement(By.tagName("button")).click();
    WebElement finishElement=driver.findElement(By.id("finish"));
    System.out.println(finishElement.getText());
}

}
