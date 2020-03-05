package DAY4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElements_Practice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();
        driver.get(" http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(2000);
     driver.findElement(By.id("disappearing_button")).click();
     Thread.sleep(2000);






driver.quit();


    }
}
