package pageObjectModel.loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.Vytrack.TestBaseClass;
import utilities.ConfigurationReader;
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
