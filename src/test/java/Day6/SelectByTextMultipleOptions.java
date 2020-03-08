package Day6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.Browserutils;

import java.util.List;

public class SelectByTextMultipleOptions {
    public static void main(String[] args) {






        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver= new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");
        Browserutils.wait(2);
        Select languages=new Select(driver.findElement(By.name("Languages")));

        boolean isMultiple=languages.isMultiple();
        System.out.println(isMultiple);
        Browserutils.wait(2);


        languages.selectByVisibleText("Java");
        languages.selectByVisibleText("JavaScript");
        languages.selectByVisibleText("Python");


        List<WebElement> selectedLanguages=languages.getAllSelectedOptions();
        for (WebElement eachLanguage:selectedLanguages){
            System.out.println(eachLanguage.getText());
        }

        Browserutils.wait(2);

        languages.deselectByVisibleText("Java");
        Browserutils.wait(2);
        languages.deselectAll();







        Browserutils.wait(2);

driver.quit();
    }
}
