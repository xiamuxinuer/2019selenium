package UnitTestPractice;

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

import java.util.List;

public class  SearchTests  {

    private WebDriver driver;

    @Test(description = "search java key word on google")
    public void googleSearchTest() throws InterruptedException {
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        Thread.sleep(3000);

        //since every search item has a tag name <h3>
        //it's the easiest way to collect all of them
        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
        for(WebElement searchItem: searchItems){
            System.out.println(searchItem.getText());
            String str=searchItem.getText();
            if (!str.isEmpty()){
                System.out.println(str);
               Assert.assertTrue(str.toLowerCase().contains("java"));
            }
        }
    }

    @Test(description = "search for java book on amazon")
    public void amazonSearchTest() throws InterruptedException {
        driver.get("http://amazon.com");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java",Keys.ENTER);
        Thread.sleep(3000);
       List<WebElement> searchItems= driver.findElements(By.tagName("h2"));
        Thread.sleep(3000);
        searchItems.get(0).click();
        Thread.sleep(3000);

        WebElement productTitle= driver.findElement(By.id("title"));
        String productTitleString=productTitle.getText();
        Assert.assertTrue(productTitleString.contains("Java"));
    }

    @BeforeMethod
    public void setup(){
        //setup webdriver
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void teardown(){
        //close browser and destroy webdriver object
        driver.quit();
    }





}