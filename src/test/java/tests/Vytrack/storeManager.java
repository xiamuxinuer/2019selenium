package tests.Vytrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class  storeManager{
    private WebDriver driver;
    private  String  url="https://qa2.vytrack.com/user/login";
    private By userNameBy=By.id("prependedInput");
    private By  passwordBy=By.id("prependedInput2");

    private String userName="storemanager85";
    private String password="UserUser123";

    Actions  actions;
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");


    @BeforeMethod
 public void setUp() throws InterruptedException {
     WebDriverManager.chromedriver().version("79").setup();
     driver=new ChromeDriver();
     actions=new Actions(driver);

     driver.get(url);
     driver.manage().window().maximize();
     Thread.sleep(3000);
     driver.findElement(userNameBy).sendKeys(userName);
     driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
     Thread.sleep(5000);
 }

    @AfterMethod
    public void tearDown(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }

    @Test
    public void callsPageTest() throws InterruptedException {

        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Calls")).click();
        Thread.sleep(5000);
        WebElement logCalls= driver.findElement(By.cssSelector("a[title='Log call']"));
        Assert.assertTrue(logCalls.isDisplayed());

    }







}
