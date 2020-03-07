package Day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Browserutils;

import java.util.List;

public class CheckBoxPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver= new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/checkboxes");
        Browserutils.wait(2);
        //verify check box1 is not selected, check box 2 is has already selected:

        List<WebElement> checkBoxes=driver.findElements(By.tagName("input"));
        for (int i = 0; i <checkBoxes.size() ; i++) {
            if (!checkBoxes.get(i).isSelected()){
                System.out.println(i+1+" check box is bot selected");
            }else {
                System.out.println(i+1+" check box is not selected yet");
            }
        }


        Browserutils.wait(2);

        if (!checkBoxes.get(0).isSelected()&&checkBoxes.get(1).isSelected()){
            System.out.println("test passed");
        }else {
            System.out.println("failed");
        }







driver.quit();




    }
}
