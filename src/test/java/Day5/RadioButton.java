package Day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BrowserUnits;

import java.util.List;

public class RadioButton {
    public static void main(String[] args)  {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver= new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        BrowserUnits.wait(2);
        driver.findElement(By.id("red")).click();

        BrowserUnits.wait(2);

// find all  radio buttons :
       List<WebElement> allButtons= driver.findElements(By.tagName("input"));

// to click each radio button by after another :
        for (WebElement eachButton:allButtons
             ) {

           // String id=eachButton.getAttribute("id");
           // System.out.println(id+"is selected ?" + eachButton.isSelected());// return true or false

            if (eachButton.isEnabled()){
                eachButton.click();
                System.out.println("clicked on "+eachButton.getAttribute("id"));
                BrowserUnits.wait(1);
            }else {
                System.out.println(eachButton.getAttribute("id")+" button is disabled ") ;
            }

        }






driver.quit();

    }
}
