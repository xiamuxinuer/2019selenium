package DAY4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElements_Practice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();
        driver.get(" http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(2000);
     driver.findElement(By.id("disappearing_button")).click();
     Thread.sleep(2000);


     if (driver.findElements(By.id("disappearing_button")).size()==0){
         System.out.println("test passed,elements does not exist.");
     }
     else {
         System.out.println("test failed");
     }

     Thread.sleep(2000);
     driver.navigate().refresh();//("disappear button appear again)


    // to click each button one bu one:

        List<WebElement> buttons=driver.findElements(By.tagName("button"));

        for (int i = 0; i <buttons.size() ; i++) {

            // driver.findElements(By.tagName("button")).get(i).click();
            buttons.get(i).click();

            Thread.sleep(2000);

        }


driver.quit();


    }
}
