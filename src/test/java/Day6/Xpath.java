package Day6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Browserutils;

public class Xpath {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver= new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Browserutils.wait(2);

        WebElement button1=driver.findElement(By.xpath("//button[@onclick='button1()']"));
        button1.click();

        Browserutils.wait(2);
        //if you don't know tag name or want to skip tag name:

        driver.findElement(By.xpath("//*[@onclick='button2()']")).click();
        Browserutils.wait(2);


       String result= driver.findElement(By.xpath("//*[@id='result']")).getText();
        System.out.println(result);

        Browserutils.wait(2);
        //xpath :use text()
        driver.findElement(By.xpath("//*[text()='Button 5']")).click();
        Browserutils.wait(2);
        //xpath: use index (start with 1)
        System.out.println(driver.findElement(By.xpath("//button[6]")).getText());
       driver.findElement(By.xpath("//button[6]")).click();



        Browserutils.wait(2);
        driver.quit();

    }
}
