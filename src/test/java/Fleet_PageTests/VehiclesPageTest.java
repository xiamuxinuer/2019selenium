package Fleet_PageTests;

import Fleet_page.LoginPage;
import Fleet_page.VehiclesPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class VehiclesPageTest extends TestBaseClass {

    @Test
    public void verifyTitle() throws InterruptedException {
        LoginPage loginPage=new LoginPage();
        VehiclesPage vehiclesPage=new VehiclesPage();

        loginPage.login();
        vehiclesPage.navigateTo("Fleet","Vehicles");
        String expectedTitle = "All - Car - Entities - System - Car - Entities - System";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }












}
