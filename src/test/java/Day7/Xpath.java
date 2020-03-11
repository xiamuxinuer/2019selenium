package Day7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Browserutils;

public class Xpath {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver= new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/login");
        Browserutils.wait(2);
        //driver.findElement(By.xpath(userNameLocator)).sendKeys("emma");
        driver.findElement(By.xpath("//*[text()='Username']/following-sibling::input")).sendKeys("Emma");
        Browserutils.wait(2);
        //driver.findElement(By.xpath(passwordLocator)).sendKeys("123");
        driver.findElement(By.xpath("//*[text()='Password']/following-sibling::input")).sendKeys("123");

        Browserutils.wait(2);
        driver.findElement(By.xpath("//*[text()='Login']")).click();


        Browserutils.wait(2);
        driver.quit();



    }

    static String userNameLocator = "//label[text()='Username']/following-sibling::input";
    static String passwordLocator = "//label[text()='Password']/following-sibling::input";

}
