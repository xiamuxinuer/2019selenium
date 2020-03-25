package Day13;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class DriverTest {


    @Test
    public void googleTest() throws InterruptedException {
        Driver.getDriver().get("http://google.com");
        Assert.assertEquals(Driver.getDriver().getTitle(),"Google");
        Thread.sleep(1000);
        Driver.closeDriver();







    }
}
