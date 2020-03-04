package Day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.DriverFactory;

public class WebElement_name {
    public static void main(String[] args) throws InterruptedException {

//WebDriverManager.chromedriver().setup();
//WebDriver driver=new ChromeDriver();


   WebDriver driver=DriverFactory.createDriver("chrome");

//http://practice.cybertekschool.com/sign_up

driver.get("http://practice.cybertekschool.com/sign_up");

WebElement  fullName=driver.findElement(By.name("full_name"));

fullName.sendKeys("Mister Twister");

Thread.sleep(5000);


        WebElement  element1=driver.findElement(By.name("email"));

      element1.sendKeys("123@gmail.com");
       Thread.sleep(5000);


        WebElement  element2=driver.findElement(By.name("wooden_spoon"));

      element2.click();
//
//
        Thread.sleep(5000);
driver.quit();






    }
}
