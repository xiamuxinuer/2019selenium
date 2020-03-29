package Vytrack_PageTests;

import Vytrack_Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class LoginPageTest extends TestBaseClass {


    /**
     * login and verify page title is "Dashboard"
     */

    @Test
    public void verifyPageTitle() throws InterruptedException {
        LoginPage loginPage=new LoginPage();
        loginPage.login();
        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");
    }


    @Test
    public void verifyWarningMessage() throws InterruptedException {
        LoginPage loginPage=new LoginPage();
        loginPage.login("wrong","123");
        Assert.assertEquals(loginPage.getWarningMessageText(), "Invalid user name or password.");
    }











}
