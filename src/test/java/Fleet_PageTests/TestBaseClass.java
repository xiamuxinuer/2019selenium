package Fleet_PageTests;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigurationReader;
import utilities.Driver;

public  abstract class TestBaseClass {
    protected WebDriverWait wait;
    protected Actions actions;
    @BeforeMethod
    public void setUp(){
        String url= ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(url);
        Driver.getDriver().manage().window().maximize();
        wait=new WebDriverWait(Driver.getDriver(),15);
        actions=new Actions(Driver.getDriver());
    }

     @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
     }

}
