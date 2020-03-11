package Day6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Browserutils;

public class cssSelector {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver= new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Browserutils.wait(2);
        driver.findElement(By.cssSelector("button[onclick='button1()']")).click();
        Browserutils.wait(2);


        System.out.println(driver.findElement(By.cssSelector("#result")).getText());

        driver.findElement(By.cssSelector(".nav-link")).click();



        Browserutils.wait(2);
        driver.quit();





    }
}
