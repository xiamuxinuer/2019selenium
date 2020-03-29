package Vytrack_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Browserutils;
import utilities.Driver;

public class Activities_CalendarEvents  extends AbstractPageBase{

    @FindBy(css ="a[title='Create Calendar event']")
    private WebElement createCalendarEventButton;

    @FindBy(className="select2-chosen")
      private WebElement defaultOwnerName;


    public void createCalenderEvent(){
        //Browserutils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEventButton)).click();
        //Browserutils.waitForPageToLoad(10);
    }

    public String getCurrentUserName(){
        wait.until(ExpectedConditions.visibilityOf(currentUser));
        return currentUser.getText().trim();
    }

    public String getDefaultOwnerName(){
        wait.until(ExpectedConditions.visibilityOf(defaultOwnerName));
        return defaultOwnerName.getText().trim();
    }
























}
