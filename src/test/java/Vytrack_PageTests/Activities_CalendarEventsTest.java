package Vytrack_PageTests;

import Vytrack_Pages.Activities_CalendarEvents;
import Vytrack_Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DateTimeUtilities;
import utilities.Driver;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

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

        String startTime=calendarEvent.getStartTime();
        String  endTime=calendarEvent.getEndTime();
        String format="h:mm a";

        Assert.assertEquals(DateTimeUtilities.getTimeDifference(startTime,endTime,format),1);
    }
@Test
public void findColumnName() throws InterruptedException {
    loginPage.login();
    calendarEvent.navigateTo("Activities", "Calendar Events");
   // System.out.println(calendarEvent.getColumnNames());
    List<String> expected= Arrays.asList("TITLE", "CALENDAR", "START", "END", "RECURRENT", "RECURRENCE", "INVITATION STATUS");
    Assert.assertEquals(calendarEvent.getColumnNames(),expected);





}

}
