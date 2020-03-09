package Day6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Browserutils;

import java.util.List;

public class Alert {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver= new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        Browserutils.wait(2);
        List<WebElement> buttons=driver.findElements(By.tagName("button"));
        // to click fist button
        buttons.get(0).click();
        Browserutils.wait(2);

        //to read alert message:
        System.out.println(driver.switchTo().alert().getText());   //I am a JS Alert

        //to click ok:
        driver.switchTo().alert().accept();
        Browserutils.wait(2);

        //to click second button:
        buttons.get(1).click();
        Browserutils.wait(2);
        // to click cancel:
        driver.switchTo().alert().dismiss();

        Browserutils.wait(2);
        //to click third button:
        buttons.get(2).click();
        Browserutils.wait(2);
        //to enter some text message:first create an alert object
      org.openqa.selenium.Alert alert=  driver.switchTo().alert();
      alert.sendKeys("hello world");
        Browserutils.wait(3);
      alert.accept();


        String actual=driver.findElement(By.id("result")).getText();

        if (actual.endsWith("hello world")){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }




        Browserutils.wait(2);

        driver.quit();
    }
}
