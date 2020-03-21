package Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.DriverFactory;
import utilities.webElements;

import java.util.Arrays;
import java.util.List;

public class webTable {
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


    @Test
    public void getColumnNames(){
        List<WebElement> columnNames=driver.findElements(By.xpath("//*[@id=\"table1\"]//thead//tr//th"));//or://table[1]//th
        List<String> expected = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        Assert.assertEquals(expected, webElements.getTextFromWebElements(columnNames));

        for (WebElement eachColumnName:columnNames){
            System.out.println(eachColumnName.getText());
        }

    }










}
