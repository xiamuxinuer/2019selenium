package Fleet_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public abstract class AbstractPageBase {
    protected WebDriver driver=Driver.getDriver();
    public AbstractPageBase(){
        PageFactory.initElements(driver,this);
    }

    public void navigateTo(String tabName,String moduleName) throws InterruptedException {
        String tabNameXpath = "//span[@class='title title-level-1' and contains(text(),'"+tabName+"')]";
        String moduleXpath="//span[@class='title title-level-2' and contains(text(),'"+moduleName+"')]";

        WebElement tabElement=driver.findElement(By.xpath(tabNameXpath));
        WebElement moduleElement=driver.findElement(By.xpath(moduleXpath));

        Actions actions=new Actions(driver);
        Thread.sleep(3000);
        actions.moveToElement(tabElement).pause(2000).click(moduleElement).build().perform();
        Thread.sleep(3000);
    }







}
