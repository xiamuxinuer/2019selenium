package DAY4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.DriverFactory;

import java.util.List;

public class findElements {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        Thread.sleep(3000);

        List<WebElement> allLinks= driver.findElements(By.tagName("a"));

        System.out.println(allLinks.size());
        for (WebElement eachLink:allLinks
             ) {
            System.out.println(eachLink.getText());
            System.out.println(eachLink.getAttribute("href"));
            System.out.println();

        }




        for(int i=1; i < allLinks.size(); i++){
            allLinks.get(i).click();
            Thread.sleep(1000);
            driver.navigate().back();
            Thread.sleep(1000);
            //refresh list
            allLinks = driver.findElements(By.tagName("a"));
        }






        driver.quit();
    }
}
