package Day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.DriverFactory;

import java.util.List;

public class webTablePractice {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver= DriverFactory.createDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



 //Go to http://practice.cybertekschool.com/tables
//Click on “Last name” column name
//Verify that table is sorted by last name in alphabetic order.
    @Test
    public void verifyLastName(){
        driver.findElement(By.xpath("//*[@id=\"table1\"]/thead/tr/th[1]/span")).click();
String str="";
        List<WebElement> allNames=driver.findElements(By.xpath("//table[1]//tbody//tr//td[1]"));
        for (int i = 0; i < allNames.size()-1; i++) {
            String firstName=allNames.get(i).getText();
            String secondName=allNames.get(i+1).getText();
            Assert.assertTrue(firstName.compareTo(secondName)<=0);
        }
    }









}
