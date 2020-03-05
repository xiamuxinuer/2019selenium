package DAY4;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.DriverFactory;

public class WarmUpTask {
    public static void main(String[] args) {

        DriverFactory.createDriver("chrome");
        WebDriver driver=new ChromeDriver();

        driver.get("http://ebay.com");
        driver.findElement(By.name("_nkw")).sendKeys("java book", Keys.ENTER);

        System.out.println(driver.findElement(By.tagName("h1")).getText());

        driver.quit();


    }
}
//Go to ebay
//enter search term
//click on search button
//print number of results



//go to amazon
//Go to ebay
//enter search term
//click on search button
//verify title contains search term



//Go to wikipedia.org
//enter search term `selenium webdriver`
//click on search button
//click on search result `Selenium (software)`
//verify url ends with `Selenium_(software)`