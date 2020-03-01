package Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class googletest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(3000);   //for demo: wait3 seconds and close


        String title=driver.getTitle(); //returns title
        System.out.println("title is "+ title);

       // driver.manage().window().maximize();
        driver.navigate().to("http://amazon.com");
        driver.navigate().forward();
        driver.navigate().refresh();
        Thread.sleep(5000);

        driver.navigate().back();
        Thread.sleep(3000);
        verifyEquals(title,"Google");
        driver.navigate().forward();
        Thread.sleep(3000);
        System.out.println("page title "+driver.getTitle());

        driver.navigate().back();

        Thread.sleep(3000);

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());


driver.close();

    }


    public static void verifyEquals(String arg1, String arg2){
        if(arg1.equalsIgnoreCase(arg2)){
            System.out.println("TEST PASSED!");
        }else{
            System.out.println("TEST FAILED");
        }
    }




}
