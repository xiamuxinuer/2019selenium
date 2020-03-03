package Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(5000);
        WebElement element=driver.findElement(By.name("q"));
        element.sendKeys("gmail", Keys.ENTER);
        Thread.sleep(5000);
        WebElement element1=driver.findElement(By.tagName("h3"));//Gmail - Google
        element1.click();
        Thread.sleep(5000);



     //   WebElement element2=driver.findElement(By.tagName("a"));
     //   element2.click();


       // driver.get("http://gmail.com");
        Thread.sleep(5000);









    }
}
