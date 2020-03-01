import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.crypto.spec.PSource;

public class Day1SeleniumClass {
    public static void main(String[] args) {


        //set up chrome driver

        WebDriverManager.chromedriver().setup();

        //create chrome driver object
        ChromeDriver driver=new ChromeDriver();
        //open some website
        driver.get("http://google.com");













    }
}
