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
        Thread.sleep(8000);   //for demo: wait 8 seconds and close


        String windowHandle=driver.getWindowHandle();
        System.out.println(windowHandle);
        //System.out.println(driver.getWindowHandle());

        Set<String> windowHandles= driver.getWindowHandles();//set does not allow duplicates.
        System.out.println(windowHandles);
        //System.out.println(driver.getWindowHandles());



        System.out.println("before switch url:"+driver.getCurrentUrl());
        System.out.println("current page is: "+driver.getTitle());
        Thread.sleep(5000);

for (String each:windowHandles){
    if (!each.equals(windowHandle)){
        driver.switchTo().window(each);
    }
}

        System.out.println("after switch url:"+driver.getCurrentUrl());
        System.out.println("current page is : "+driver.getTitle());
        Thread.sleep(8000);



         driver.close();   // close where you at

       // driver.quit();// close all the windows that opened by driver.


//
//        String pageTitle=driver.getTitle();
//        switchToWindowBasedOnTitle(pageTitle,driver);


    }


    //
    /**
     *
     * This method helps to switch in between windows based on page title
     * @param pageTitle
     * @param driver
     */
    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver){
        Set<String> windows = driver.getWindowHandles();
        for (String eachWindow: windows){
            driver.switchTo().window(eachWindow);
            if (driver.getTitle().equals(pageTitle)){
                break;
            }
        }
    }





}

