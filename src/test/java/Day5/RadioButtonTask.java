package Day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Browserutils;

public class RadioButtonTask {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver= new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        Browserutils.wait(2);

        WebElement blackButton=driver.findElement(By.id("black"));

        Browserutils.wait(2);

        if (blackButton.isDisplayed()&&blackButton.isEnabled()){
            blackButton.click();
            System.out.println("clicked on black button ");
        }
        Browserutils.wait(2);

       // System.out.println("has black button selected ?: "+blackButton.isSelected());
      // System.out.println("has black button enabled ?:" +blackButton.isEnabled());

          if (blackButton.isSelected()){
              System.out.println("test passed");
          }else {
              System.out.println("test failed");
          }










driver.quit();
    }
}
