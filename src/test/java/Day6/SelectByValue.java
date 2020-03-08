package Day6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.Browserutils;

public class SelectByValue {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver= new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");
        Browserutils.wait(2);


        Select stateSelect=new Select(driver.findElement(By.id("state")));
        stateSelect.selectByValue("DC");
        String expected="District Of Columbia";
        String actual=stateSelect.getFirstSelectedOption().getText();
        System.out.println(actual);
        if (expected.equalsIgnoreCase(actual)){
            System.out.println("test passed");
        }else {
            System.out.println("test failed");
        }





driver.quit();

    }
}
