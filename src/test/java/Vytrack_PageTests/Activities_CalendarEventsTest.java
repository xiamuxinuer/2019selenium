package Vytrack_PageTests;

import Vytrack_Pages.Activities_CalendarEvents;
import Vytrack_Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.DateTimeUtilities;
import utilities.Driver;
import utilities.webTable;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class Activities_CalendarEventsTest extends TestBaseClass {


    @Test
    public void verifyDefaultOwner() throws InterruptedException {
        LoginPage loginPage=new LoginPage();
        Activities_CalendarEvents calendarEvent=new Activities_CalendarEvents();
        test=report.createTest("verify default owner");
        loginPage.login();
        calendarEvent.navigateTo("Activities", "Calendar Events");
        calendarEvent.createCalenderEvent();

        Assert.assertEquals(calendarEvent.getCurrentUserName(),calendarEvent.getDefaultOwnerName());

        Assert.assertEquals(calendarEvent.getStartDate(), DateTimeUtilities.getTodaysDate("MMM d, yyyy"));

        String startTime=calendarEvent.getStartTime();
        String  endTime=calendarEvent.getEndTime();
        String format="h:mm a";

        Assert.assertEquals(DateTimeUtilities.getTimeDifference(startTime,endTime,format),1);
        test.pass("default name verified");
    }
@Test
public void findColumnName() throws InterruptedException {
    LoginPage loginPage=new LoginPage();
    Activities_CalendarEvents calendarEvent=new Activities_CalendarEvents();
    test=report.createTest("find column name");
    loginPage.login();
    calendarEvent.navigateTo("Activities", "Calendar Events");
   // System.out.println(calendarEvent.getColumnNames());
    List<String> expected= Arrays.asList("TITLE", "CALENDAR", "START", "END", "RECURRENT", "RECURRENCE", "INVITATION STATUS");
    Assert.assertEquals(calendarEvent.getColumnNames(),expected);
   test.pass("test pass");
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

@Test
    public void deselectCheckBoxes() throws InterruptedException {
    LoginPage loginPage=new LoginPage();
    Activities_CalendarEvents calendarEvent=new Activities_CalendarEvents();


    test=report.createTest("deselect check boxes");

    loginPage.login("storemanager85","UserUser123");

    calendarEvent.navigateTo("Activities","Calendar Events");

    calendarEvent.deselectCheckBoxes();

    Assert.assertTrue(calendarEvent.displayedColumn().isDisplayed());
}


@Test
    public void verifyDropDownOptions() throws InterruptedException {
    LoginPage loginPage=new LoginPage();
    Activities_CalendarEvents calendarEvent=new Activities_CalendarEvents();


    test=report.createTest("verify drop down menu");

    loginPage.login("storemanager85","UserUser123");

    calendarEvent.navigateTo("Activities","Calendar Events");
    calendarEvent.createCalenderEvent();
    calendarEvent.clickExtendSaveAndClose();
    Assert.assertTrue(!calendarEvent.getExtendOptions().isEmpty());

    List<String> expected = Arrays.asList(new String[]{"Save And Close", "Save And New", "Save"});
    List<String> actual= webTable.getTextFromWebElements(calendarEvent.getExtendOptions());

Assert.assertEquals(expected,actual);
}











}
