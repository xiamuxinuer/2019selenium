package tests.Vytrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FleetVehiclesPageTest {
    private WebDriver driver;
    private  String  url="https://qa2.vytrack.com/user/login";
    private By userNameBy=By.id("prependedInput");
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


   @Test
   public void pageSubTitle() throws InterruptedException {
        driver.findElement(userNameBy).sendKeys(userName);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        Thread.sleep(3000);
        //driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span")).click();//find fleet
       Actions actions=new Actions(driver);
       actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"))).perform();//move to fleet option


       Thread.sleep(3000);
       driver.findElement(By.linkText("Vehicles")).click();// find vehicle


       Thread.sleep(5000);
       String actual=driver.findElement(By.className("oro-subtitle")).getText();// find sub title
       System.out.println(actual);
       String expected="All Cars";
       Assert.assertEquals(actual,expected," sub title does not match");

   }









}
