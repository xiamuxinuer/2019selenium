package Day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.Browserutils;

public class FileUplaoding {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver= new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/upload");
        Browserutils.wait(3);
        WebElement upLoad=driver.findElement(By.id("file-upload"));

        //String filePath="C:\\Users\\akbar\\Desktop\\Alex Anzhaer cover letter.docx";
        String picPath="C:\\Users\\akbar\\Desktop\\Capture - Shortcut.lnk";

        upLoad.sendKeys(picPath);

        Browserutils.wait(3);


        driver.findElement(By.id("file-submit")).click();




        Browserutils.wait(3);




driver.quit();

    }
}
