package Vytrack_PageTests;

import Vytrack_Pages.LoginPage;
import Vytrack_Pages.Fleet_VehiclesPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class Fleet_VehiclesPageTest extends TestBaseClass {

    @Test
    public void verifyTitle() throws InterruptedException {
        LoginPage loginPage=new LoginPage();
        Fleet_VehiclesPage vehiclesPage=new Fleet_VehiclesPage();

        test=report.createTest("verify title");
        loginPage.login();
        vehiclesPage.navigateTo("Fleet","Vehicles");
        String expectedTitle = "All - Car - Entities - System - Car - Entities - System";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        test.pass("title verified");
    }












}
