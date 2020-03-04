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
String expected="Welcome to the Secure Area. When you are done click logout below.";
String actual=driver.findElement(By.tagName("h4")).getText();
        if (actual.equalsIgnoreCase(expected)) {
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }

        Thread.sleep(5000);

        //driver.findElement(By.linkText("Logout")).click();
        driver.findElement(By.partialLinkText("Logout")).click();
        Thread.sleep(3000);



        driver.quit();

    }

}
