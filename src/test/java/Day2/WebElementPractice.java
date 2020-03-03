package Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementPractice {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(8000);   //for demo: wait3 seconds and close

        driver.close();   // only old window closed. new window still open.

driver.quit();// close all the windows that opened by driver.







    }
}
