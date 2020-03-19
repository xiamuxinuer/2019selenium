package Day9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class JSExecutor  {

    private RemoteWebDriver driver;

  @BeforeMethod
  public void setUp(){
      WebDriverManager.chromedriver().version("79").setup();
      driver=new ChromeDriver();

  }

  @AfterMethod
  public void tearDown() {
      driver.quit();
  }

  @Test
  public void scrollTest() throws InterruptedException {
      driver.get("http://practice.cybertekschool.com/infinite_scroll");
      Thread.sleep(3000);


      driver.executeScript("window.scrollBy(0,250)");
      Thread.sleep(3000);
  }

  @Test
    public void scrollToEnd() throws InterruptedException {
      driver.get("http://practice.cybertekschool.com");
      Thread.sleep(3000);

      WebElement link= driver.findElement(By.linkText("Cybertek School"));
      driver.executeScript("arguments[0].scrollIntoView(true)",link);

      Thread.sleep(3000);


  }











}
