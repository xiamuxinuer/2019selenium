package Day6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import utilities.Browserutils;

import java.util.List;

public class DropDowns {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver= new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");
        Browserutils.wait(2);

        WebElement simpleDropDown=driver.findElement(By.id("dropdown"));

        Select selectSimpleDropDown=new Select(simpleDropDown);

        selectSimpleDropDown.selectByVisibleText("Option 1");
        System.out.println("option 1 selected");
        Browserutils.wait(2);
        selectSimpleDropDown.selectByVisibleText("Option 2");
        System.out.println("option 2 selected");

        Select selectYear=new Select(driver.findElement(By.id("year")));
        selectYear.selectByVisibleText("2003");
        Browserutils.wait(1);
        System.out.println("select year");


        Select selectMonth=new Select(driver.findElement(By.id("month")));
        selectMonth.selectByVisibleText("January");
        Browserutils.wait(1);
        System.out.println("select month");

        Select selectDay=new Select(driver.findElement(By.id("day")));
        selectDay.selectByVisibleText("1");
        Browserutils.wait(1);
        System.out.println("select day");
        Browserutils.wait(1);



        List<WebElement> months=selectMonth.getOptions();
        for (WebElement eachMonth:months){
            selectMonth.selectByVisibleText(eachMonth.getText());
            System.out.println(eachMonth.getText());
            Browserutils.wait(1);
        }













        Browserutils.wait(2);

driver.quit();

    }
}
