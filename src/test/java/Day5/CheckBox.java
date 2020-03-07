package Day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.BrowserUnits;

import java.util.List;

public class CheckBox {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver= new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUnits.wait(2);

        List<WebElement> checkBoxes=driver.findElements(By.tagName("input"));
//        checkBoxes.get(0).click();


        for (WebElement eachCheckBox:checkBoxes
             ) {
            if (!eachCheckBox.isSelected()){

          eachCheckBox.click();
            }else {
                System.out.println("already selected");
            }
            BrowserUnits.wait(2);
        }

//        checkBoxes.get(1).click();
//        BrowserUnits.wait(1);







driver.quit();


    }
}
