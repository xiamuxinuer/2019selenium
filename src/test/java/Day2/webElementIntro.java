package Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webElementIntro {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://google.com");

        Thread.sleep(5000);

        org.openqa.selenium.WebElement search=driver.findElement(By.name("q"));

       search.sendKeys("Java", Keys.ENTER);

        Thread.sleep(3000);


       org.openqa.selenium.WebElement news=driver.findElement(By.linkText("News"));

       news.click();




        Thread.sleep(5000);
        driver.quit();


    }
}
