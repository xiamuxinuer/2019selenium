package tests.Vytrack.login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.Browserutils;

public class LoginPageTests {

    private WebDriver driver;
    private  String  url="https://qa2.vytrack.com/user/login";
    private By  userNameBy=By.id("prependedInput");
    private By  passwordBy=By.id("prependedInput2");
    private By  warningBy=By.xpath("//div[text()='Invalid user name or password.']");
    private String userName="storemanager85";
    private String password="UserUser123";


    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }

@Test(description = "verify that warning message displays when user enters invalid user name")
public void invalidUserName() throws InterruptedException {

    driver.findElement(userNameBy).sendKeys("emma");
    driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
   Thread.sleep(3000);


    WebElement warningMessage=driver.findElement(warningBy);
    Assert.assertTrue(warningMessage.isDisplayed());

    String actual=warningMessage.getText();
    String expected="Invalid user name or password.";
    Assert.assertEquals(actual,expected,"message does not match");

    }


    @Test
    public void validCredential() throws InterruptedException {
        driver.findElement(userNameBy).sendKeys(userName);
        driver.findElement(passwordBy).sendKeys(password,Keys.ENTER);
        Thread.sleep(3000);

        String actual=driver.getTitle();
        String expected="Dashboard";
        Assert.assertEquals(actual,expected,"page title is not correct");




    }











}





