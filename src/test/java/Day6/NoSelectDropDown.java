package Day6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.Browserutils;

import java.util.List;

public class NoSelectDropDown {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver= new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");
        Browserutils.wait(2);

        driver.findElement(By.id("dropdownMenuLink")).click();// find drop down and click to expend it and see the options:

        Browserutils.wait(2);

        List<WebElement> allLinks=driver.findElements(By.className("dropdown-item"));
        for (WebElement eachLink:allLinks){
            System.out.println(eachLink.getText()+": "+eachLink.getAttribute("href"));
        }


        driver.findElement(By.linkText("Amazon")).click();//find drop down option and click it
        Browserutils.wait(2);
        driver.navigate().back();
        Browserutils.wait(2);

        driver.findElement(By.id("dropdownMenuLink")).click();
        Browserutils.wait(2);
        System.out.println(driver.findElement(By.linkText("Google")).getAttribute("href"));
        driver.findElement(By.linkText("Google")).click();


        Browserutils.wait(2);
driver.quit();

    }
}
