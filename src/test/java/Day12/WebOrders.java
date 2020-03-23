package Day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.DriverFactory;

import java.util.List;

public class WebOrders {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createDriver("chrome");
        wait=new WebDriverWait(driver,15);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
       Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void checkBoxTest(){
        WebElement checkAllButton=driver.findElement(By.linkText("Check All"));
        checkAllButton.click();

        List<WebElement> allCheckBoxes=driver.findElements(By.cssSelector("input[type='checkbox']")) ;

        for (WebElement eachBox:allCheckBoxes) {
            Assert.assertTrue(eachBox.isSelected());
        }

    }

    /**
     * :: TASK for 10 minutes ::
     * Go to web orders page
     * Verify that Steve Johns zip code is 21233
     * Then update his zip code to 20002
     * Then verify that Steve Johns zip code is 20002
     */
    @Test
    public void updateZipCode(){

        WebElement zipCode= driver.findElement(By.xpath("//td[text()='21233']"));
        Assert.assertEquals(zipCode.getText(),"21233");

        driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[4]/td[13]/input")).click();

        WebElement zipCodeInput= driver.findElement(By.cssSelector("input[name='ctl00$MainContent$fmwOrder$TextBox5']"));
        zipCodeInput.clear();
        zipCodeInput.sendKeys("20002");

        driver.findElement(By.linkText("Update")).click();
        zipCode= driver.findElement(By.xpath("//td[text()='20002']"));
        Assert.assertEquals(zipCode.getText(),"20002");

    }








}
