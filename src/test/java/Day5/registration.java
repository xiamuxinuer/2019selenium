package Day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Browserutils;

import java.util.List;

public class registration {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver= new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/registration_form");

        Browserutils.wait(2);


        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("username")).sendKeys("Jsmith");
        driver.findElement(By.name("email")).sendKeys("jsmith@email.com");
        driver.findElement(By.name("password")).sendKeys("supersecretpassword2020");
        driver.findElement(By.name("phone")).sendKeys("405-314-6019");
        List<WebElement> genders=driver.findElements(By.name("gender"));
        genders.get(2).click();


        driver.findElement(By.name("birthday")).sendKeys("01/01/1985");
        driver.findElement(By.id("inlineCheckbox2")).click();

        driver.findElement(By.id("wooden_spoon")).click();

        Browserutils.wait(5);


        driver.quit();

    }
}
