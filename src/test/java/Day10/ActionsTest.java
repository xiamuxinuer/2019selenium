package Day10;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest {
    private WebDriver driver;
    private Actions actions;

   @BeforeMethod
   public void setUp(){
       WebDriverManager.chromedriver().version("79").setup();
       driver=new ChromeDriver();

   }

   @AfterMethod
   public void tearDown(){
       driver.quit();
   }

    @Test
    public void hoverOnImage() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
       Thread.sleep(3000);
       WebElement img1= driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2= driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3= driver.findElement(By.xpath("(//img)[3]"));
         actions=new Actions(driver);

        actions.moveToElement(img1).pause(1000).moveToElement(img2).build().perform();
        String user2=  driver.findElement(By.xpath("(//h5)[2]")).getText();
        System.out.println(user2);
        Thread.sleep(3000);
        actions.moveToElement(img1).pause(1000).build().perform();
        Thread.sleep(3000);
        WebElement user1 =driver.findElement(By.xpath("(//h5)[1]"));
        Assert.assertTrue(user1.isDisplayed());
        driver.findElement(By.linkText("View profile")).click();
        Thread.sleep(3000);


    }






}
