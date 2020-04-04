package Vytrack_PageTests;

import Vytrack_Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.Browserutils;
import utilities.Driver;

public class LoginPageTest extends TestBaseClass {


    /**
     * login and verify page title is "Dashboard"
     */

    @Test
    public void verifyPageTitle() throws InterruptedException {
        // we must add to every test at the beginning :
        test=report.createTest("verify page title");
        LoginPage loginPage=new LoginPage();
        loginPage.login();
        // just like :  system.out.println();
        test.info("log as store manager");
        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");
       test.pass("Page title Dashboard was verified");
    }


    @Test
    public void verifyWarningMessage() throws InterruptedException {
        test=report.createTest("verify warning message");
        LoginPage loginPage=new LoginPage();
        loginPage.login("wrong","123");

        Assert.assertEquals(loginPage.getWarningMessageText(), "Invalid user name or password.");
       test.pass("warning message is displayed");
    }


@DataProvider
    public  Object [][] credentials(){
        return new Object[][]{
                {"storemanager85","UserUser123"},
                {"user16","UserUser123"}
        };
}

@Test(dataProvider = "credentials")
    public void loginWithDDT(String userName, String password) throws InterruptedException {
    // we must add to every test at the beginning :
    test=report.createTest("verify page title as "+userName);
    LoginPage loginPage=new LoginPage();
    loginPage.login(userName, password);
    // just like :  system.out.println();
    test.info("log as "+userName);
    Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");
    test.pass("Page title Dashboard was verified");
}






}
