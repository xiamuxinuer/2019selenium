package Vytrack_PageTests;

import Vytrack_Pages.Activities_CalendarEvents;
import Vytrack_Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DateTimeUtilities;
import utilities.Driver;

import java.util.Calendar;

public class Activities_CalendarEventsTest extends TestBaseClass {

    LoginPage loginPage=new LoginPage();
    Activities_CalendarEvents calendarEvent=new Activities_CalendarEvents();
    @Test
    public void verifyDefaultOwner() throws InterruptedException {

        loginPage.login();
        calendarEvent.navigateTo("Activities", "Calendar Events");
        calendarEvent.createCalenderEvent();

        Assert.assertEquals(calendarEvent.getCurrentUserName(),calendarEvent.getDefaultOwnerName());

        Assert.assertEquals(calendarEvent.getStartDate(), DateTimeUtilities.getTodaysDate("MMM dd, yyyy"));
    }



}
