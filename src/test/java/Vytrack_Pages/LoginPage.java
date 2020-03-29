package Vytrack_Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigurationReader;
import utilities.Driver;

public class LoginPage  {
    @FindBy(id = "prependedInput")
    private   WebElement username;

    @FindBy(id ="prependedInput2")
    private   WebElement password;

    @FindBy(id = "_submit")
     WebElement loginButton;

    @FindBy(linkText = "Forgot your password?")
    public WebElement forgotPassword;

    @FindBy(css = "[class='alert alert-error']")
    private WebElement warningMessage;


    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    public void login(String usernameValue,String passwordValue) throws InterruptedException {
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue);
        loginButton.click();
        Thread.sleep(3000);

    }
    public void login() throws InterruptedException {
        username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        Thread.sleep(3000);
    }


    public String getWarningMessageText(){
        return  warningMessage.getText();
    }



}
