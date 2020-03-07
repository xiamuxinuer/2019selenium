package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver createDriver(String browserName){
        if (browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().version("79").setup();
            return new ChromeDriver();
        }else {
            WebDriverManager.firefoxdriver().version("79").setup();
            return new FirefoxDriver();
        }
    }










}
