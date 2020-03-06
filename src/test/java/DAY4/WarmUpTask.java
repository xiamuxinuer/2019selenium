package DAY4;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.DriverFactory;

public class WarmUpTask {
    public static void main(String[] args) throws InterruptedException {

//call the methods:

       ebayTask();

        amazonTask();


        wikipediaTask();


    }
    //Go to ebay
//enter search term
//click on search button
//print number of results
    public static void  ebayTask(){
     WebDriver   driver=DriverFactory.createDriver("chrome");

        driver.get("http://ebay.com");
        driver.findElement(By.name("_nkw")).sendKeys("java book",Keys.RETURN);

        System.out.println(driver.findElement(By.tagName("h1")).getText());

        driver.quit();

    }

//go to amazon
//enter search term
//click on search button
//verify title contains search term
    public static void amazonTask() throws InterruptedException {
        WebDriver   driver=DriverFactory.createDriver("chrome");
        driver.get("http://amazon.com");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book",Keys.ENTER);

        Thread.sleep(2000);
        String title=driver.getTitle();
        //System.out.println(title);
       if (title.contains("java book")){
           System.out.println("true");
       }else {
           System.out.println("false");
       }
        driver.quit();

    }

//Go to wikipedia.org
//enter search term `selenium webdriver`
//click on search button
//click on search result `Selenium (software)`
//verify url ends with `Selenium_(software)`
public static void wikipediaTask(){
    WebDriver   driver=DriverFactory.createDriver("chrome");
        driver.get("http://wikipedia.org");
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver",Keys.ENTER);
        driver.findElement(By.linkText("Selenium (software)")).click();
        boolean result=driver.getCurrentUrl().endsWith("Selenium_(software)");
    System.out.println(result);
    driver.quit();
}


}




