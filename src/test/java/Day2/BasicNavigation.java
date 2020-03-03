package Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("http://google.com");
        //Thread.sleep(3000);   //for demo: wait3 seconds and close


        String title=driver.getTitle(); //returns title
        System.out.println("title is "+ title);
        String expectedTitle="Google";
        if (expectedTitle.equals(title)) {

            System.out.println("test passed");

        }else {
            System.out.println("test fail");
        }



        driver.close();








    }
}
