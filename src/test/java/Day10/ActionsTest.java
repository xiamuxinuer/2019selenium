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
        String user2=  driver.findElement(By.xpath("(//h5)[2]")).getText();//--->>>//h5[text()='name: user2']
        System.out.println(user2);
        Thread.sleep(3000);
        actions.moveToElement(img1).pause(1000).build().perform();
        Thread.sleep(3000);
        WebElement user1 =driver.findElement(By.xpath("(//h5)[1]"));//-->>>   //h5[text()='name: user1']
        Assert.assertTrue(user1.isDisplayed());
        driver.findElement(By.linkText("View profile")).click();
        Thread.sleep(3000);


    }


    @Test
    public void hoverAction() throws InterruptedException {
       driver.get("http://practice.cybertekschool.com");
        Thread.sleep(3000);
        driver.findElement(By.linkText("JQuery UI Menus")).click();
        Thread.sleep(3000);

        actions=new Actions(driver);
        WebElement enabled=driver.findElement(By.id("ui-id-3"));
        WebElement download=driver.findElement(By.id("ui-id-4"));
        actions.moveToElement(enabled).pause(2000).moveToElement(download).pause(2000).perform();
        driver.findElement(By.id("ui-id-5")).click();   //pdf element
        Thread.sleep(2000);

    }








}
