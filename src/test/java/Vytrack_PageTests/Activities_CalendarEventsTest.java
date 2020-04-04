package Vytrack_PageTests;

import Vytrack_Pages.Activities_CalendarEvents;
import Vytrack_Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.DateTimeUtilities;
import utilities.Driver;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Activities_CalendarEventsTest extends TestBaseClass {


    @Test
    public void verifyDefaultOwner() throws InterruptedException {
        LoginPage loginPage=new LoginPage();
        Activities_CalendarEvents calendarEvent=new Activities_CalendarEvents();
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
    LoginPage loginPage=new LoginPage();
    Activities_CalendarEvents calendarEvent=new Activities_CalendarEvents();
    loginPage.login();
    calendarEvent.navigateTo("Activities", "Calendar Events");
   // System.out.println(calendarEvent.getColumnNames());
    List<String> expected= Arrays.asList("TITLE", "CALENDAR", "START", "END", "RECURRENT", "RECURRENCE", "INVITATION STATUS");
    Assert.assertEquals(calendarEvent.getColumnNames(),expected);

}
@DataProvider
public Object[][] calendarEvent(){
        return new Object[][]{
                {"daily stand-up", "scrum meeting to provide updates"},
                {"sprint planning meeting","analyze user story"},
//                {"three amigo's meeting","discuss with developers"},
//                {"demo meeting","demo product to client"},
//                {"sprint retro meeting"," discuss previous sprint"}
        };
}

@Test(dataProvider ="calendarEvent")
    public void createCalenderEventTest(String title,String description) throws InterruptedException {
    LoginPage loginPage=new LoginPage();
    Activities_CalendarEvents calendarEvent=new Activities_CalendarEvents();


       test=report.createTest("create calender event for "+ title);
       loginPage.login();
       calendarEvent.navigateTo("Activities","Calendar Events");
       calendarEvent.createCalenderEvent();
       calendarEvent.enterCalendarEventTitle(title);
       calendarEvent.enterCalendarEventDescription(description);
       calendarEvent.clickAndSave();
       Assert.assertEquals(calendarEvent.getInputTitle(),title);

       Assert.assertEquals(calendarEvent.getDescription(),description);
       test.pass("calender event was created successfully");
}








}
