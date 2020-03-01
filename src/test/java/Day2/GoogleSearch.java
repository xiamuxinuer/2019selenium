package Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://google.com");

        Thread.sleep(5000);

        WebElement search=driver.findElement(By.name("q"));

       search.sendKeys("Java", Keys.ENTER);


        Thread.sleep(5000);
        driver.quit();


    }
}
