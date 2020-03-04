package Day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.DriverFactory;

public class WebElementPractice {
    public static void main(String[] args) throws InterruptedException {

//WebDriverManager.chromedriver().setup();
//WebDriver driver=new ChromeDriver();


   WebDriver driver=DriverFactory.createDriver("chrome");

//http://practice.cybertekschool.com/sign_up

driver.get("http://practice.cybertekschool.com/sign_up");

WebElement  element=driver.findElement(By.name("full_name"));

element.sendKeys("akbar", Keys.ENTER);
Thread.sleep(5000);


        WebElement  element1=driver.findElement(By.name("email"));

        element.sendKeys("123", Keys.ENTER);
        Thread.sleep(5000);


        WebElement  element2=driver.findElement(By.name("wooden_spoon"));

       element2.click();

        Thread.sleep(5000);

driver.quit();






    }
}
