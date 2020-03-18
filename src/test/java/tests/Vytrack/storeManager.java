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

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class  storeManager{
    private WebDriver driver;
    private  String  url="https://qa2.vytrack.com/user/login";
    private By userNameBy=By.id("prependedInput");
    private By  passwordBy=By.id("prependedInput2");

    private String userName="storemanager85";
    private String password="UserUser123";

    Actions  actions;
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By currentUserBy = By.cssSelector("#user-menu > a");//[id=user-menu] go to child element use " > a"
    private By startDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid']");
    private By startTimeBy = By.cssSelector("[id*='time_selector_oro_calendar_event_form_start-uid']");

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
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
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
        driver.findElement(By.linkText("Calls")).click();
        Thread.sleep(5000);
        WebElement logCalls= driver.findElement(By.cssSelector("a[title='Log call']"));
        Assert.assertTrue(logCalls.isDisplayed());

    }

    @Test
    public void calendarPageTest() throws InterruptedException {
        driver.findElement(By.linkText("Calendar Events")).click();
        Thread.sleep(5000);
        WebElement calendar = driver.findElement(By.cssSelector("a[title='Create Calendar event']"));
        Assert.assertTrue(calendar.isDisplayed());


    }
//Login as sales manager
//Go to Activities --> Calendar Events
//Click on Create Calendar Event
//Default owner name should be current user
//Default title should be blank
//Default start date should be current date
//Default start time should be current time

    @Test
    public void defaultOwner() throws InterruptedException {
        driver.findElement(By.linkText("Calendar Events")).click();
        Thread.sleep(5000);
       driver.findElement(By.cssSelector("a[title='Create Calendar event']")).click();
        Thread.sleep(5000);
       String currentUser= driver.findElement(currentUserBy).getText().trim();
       String defaultUser=driver.findElement(By.cssSelector("span[class='select2-chosen']")).getText().trim();
       Assert.assertEquals(defaultUser,currentUser);

       WebElement defaultTitle=driver.findElement(By.name("oro_calendar_event_form[title]"));//find input title box
       Assert.assertTrue(defaultTitle.getAttribute("value").isEmpty());


       WebElement startDate=driver.findElement(By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid']"));
       String actualDay=startDate.getAttribute("value");
       String expectedDate= LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
       Assert.assertEquals(actualDay,expectedDate);

       WebElement startTime=driver.findElement(startTimeBy);
       String  actualTime=startTime.getAttribute("value");
       String  expectedTime= LocalTime.now().format(DateTimeFormatter.ofPattern("h:m a"));
       Assert.assertEquals(actualTime,expectedTime,"time is not correct");






    }











}
