package Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToNewWindow {
    public static void main(String[] args) throws InterruptedException {



        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(8000);   //for demo: wait3 seconds and close


        String windowHandle=driver.getWindowHandle();
        System.out.println(windowHandle);
        //System.out.println(driver.getWindowHandle());

        Set<String> windowHandles= driver.getWindowHandles();//set does not allow duplicates.
        System.out.println(windowHandles);
        //System.out.println(driver.getWindowHandles());
        System.out.println("before switch url:"+driver.getCurrentUrl());
for (String windowId:windowHandles){
    if (!windowId.equals(windowHandle)){
        driver.switchTo().window(windowId);
    }
}
        System.out.println("after switch url:"+driver.getCurrentUrl());

        Thread.sleep(8000);



         //driver.close();   // only old window closed. new window still open.

        driver.quit();// close all the windows that opened by driver.



    }


    //
    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver){
        Set<String> windows = driver.getWindowHandles();
        for (String window: windows){
            driver.switchTo().window(window);
            if (driver.getTitle().equals(pageTitle)){
                break;
            }
        }
    }







}

