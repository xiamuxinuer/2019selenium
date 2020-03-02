package Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigationMethods {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(3000);   //for demo: wait3 seconds and close


        String title=driver.getTitle(); //returns title
        System.out.println("title is "+ title);

       // driver.manage().window().maximize();
        driver.navigate().to("http://amazon.com");

        if (driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("test passed");
        }
        else {
            System.out.println("test failed");
        }
        Thread.sleep(3000);

//come back to google page:
        driver.navigate().back();

        Thread.sleep(3000);


// go to amazon again then refresh the amazon page
        driver.navigate().forward();
        driver.navigate().refresh();
        Thread.sleep(5000);
// go back to google page:
        driver.navigate().back();
        Thread.sleep(3000);


     //call the method:
        verifyEquals(title,"Google");


   //go to amazon page :
        driver.navigate().forward();
        Thread.sleep(3000);
        System.out.println("page title "+driver.getTitle());// page title is :amazon
        System.out.println("current page url: "+driver.getCurrentUrl());

        //go back to google page:
        driver.navigate().back();

        Thread.sleep(3000);

        System.out.println(driver.getTitle());// page title is : google
        System.out.println(driver.getCurrentUrl());// google url : https://www.google.com/?gws_rd=ssl


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
