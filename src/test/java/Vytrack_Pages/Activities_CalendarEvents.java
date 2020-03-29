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
    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    private WebElement startDate;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    private  WebElement startTime;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    private  WebElement endTime;

    public void createCalenderEvent(){
        Browserutils.waitForPageToLoad(10);
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


    public String getStartDate(){
        Browserutils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(startDate));
        return startDate.getAttribute("value");
    }


    public String getStartTime(){
        Browserutils.waitForPageToLoad(15);
        wait.until(ExpectedConditions.visibilityOf(startTime));
        return startTime.getAttribute("value");
    }

    public String getEndTime() {
        Browserutils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(endTime));
        return endTime.getAttribute("value");

    }

}
