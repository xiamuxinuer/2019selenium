package UnitTestPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class practiceTests {
     public ChromeDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }


    @AfterMethod
    public void teardown(){
        //close browser and destroy webdriver object
        driver.quit();
    }

    @Test
    public void loginTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[21]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(1000);
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        Thread.sleep(1000);
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(1000);

       String  actual=driver.findElement(By.tagName("h4")).getText();

       String  expected="Welcome to the Secure Area. When you are done click logout below.";
      Assert.assertEquals(actual,expected,"message is not match");

    }

@Test
    public  void  forgetPasswordTest() throws InterruptedException {
         driver.findElement(By.linkText("Forgot Password")).click();
    Thread.sleep(1000);
         driver.findElement(By.name("email")).sendKeys("efewtrell8c@craigslist.org", Keys.ENTER);
    Thread.sleep(1000);
        String actual=driver.findElement(By.tagName("h4")).getText();
        String expected="Your e-mail's been sent!";
        Assert.assertEquals(actual,expected,"message is not match");





}





}
