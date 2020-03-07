package Day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Browserutils;

public class iFrame {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/iframe");
        Browserutils.wait(2);
        //to go into the frame:
        driver.switchTo().frame("mce_0_ifr");
        WebElement inputText=driver.findElement(By.id("tinymce"));
        System.out.println(inputText.getText());
        Browserutils.wait(2);
        inputText.clear();
        inputText.sendKeys("hello world");
        Browserutils.wait(4);
        System.out.println(inputText.getText());
        // to get out of frame:
        driver.switchTo().defaultContent();

        System.out.println(driver.findElement(By.tagName("h3")).getText());




driver.quit();


    }
}
