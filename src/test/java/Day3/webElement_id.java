package Day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;

public class webElement_id {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(5000);
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        Thread.sleep(5000);
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(5000);

        driver.quit();






    }

}
