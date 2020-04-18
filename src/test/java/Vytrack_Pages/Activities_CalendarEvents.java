package Vytrack_Pages;

import Day9.JSExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.Browserutils;
import utilities.webTable;

import java.util.List;

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

    @FindBy(className = "grid-header-cell__label")
    private List<WebElement> columnNames;


    @FindBy(css = "[id^='oro_calendar_event_form_title-uid']")
    private WebElement title;


    @FindBy(css = "iframe[id^='oro_calendar_event_form_description-uid']")
    private WebElement descriptionFrame;

   @FindBy(id = "tinymce")
    private WebElement textInputArea;

    @FindBy(css = "[class='btn-group pull-right'] > button")
    private WebElement saveAndClose;




    @FindBy(xpath = "//a[@class='btn-success btn dropdown-toggle']")
    private WebElement extendSaveAndClose;

    @FindBy(xpath = "//ul[@class='dropdown-menu']/li/button")
    private List<WebElement> extendOptions;

    @FindBy(xpath = "(//ul[@class='dropdown-menu']/li/button)[1]")
    private WebElement extendOption1;

    @FindBy(xpath = "(//ul[@class='dropdown-menu']/li/button)[2]")
    private WebElement extendOption2;


    @FindBy(xpath = "(//ul[@class='dropdown-menu']/li/button)[3]")
    private WebElement extendOption3;





    @FindBy(xpath = "(//div[@class='control-label'])[1]")
    private  WebElement actualTitleInput;


    @FindBy(xpath = "//i[@class='fa-cog hide-text']")
    private  WebElement gridSetting;

    @FindBy(xpath = "//tbody/tr/td[3]/input")
    private List<WebElement> allCheckBoxes;

    @FindBy(xpath = "//tbody/tr/td/label")
    private List<WebElement> nameColumn;


    @FindBy(xpath = "//tbody/tr[1]/td[3]/input")
    private WebElement Checkbox1;

    @FindBy(xpath = "//tbody/tr[2]/td[3]/input")
    private WebElement Checkbox2;

    @FindBy(xpath = "//tbody/tr[3]/td[3]/input")
    private WebElement Checkbox3;


    @FindBy(xpath = "//tbody/tr[4]/td[3]/input")
    private WebElement Checkbox4;



    @FindBy(xpath = "//tbody/tr[5]/td[3]/input")
    private WebElement Checkbox5;



    @FindBy(xpath = "//tbody/tr[6]/td[3]/input")
    private WebElement Checkbox6;



    @FindBy(xpath = "//tbody/tr[7]/td[3]/input")
    private WebElement Checkbox7;


    @FindBy(css = "span[class='close']")
    private WebElement closeSign;

    @FindBy(xpath = "(//span[@class=\"grid-header-cell__label\"])[1]")
    private WebElement titleColumn;


    @FindBy(linkText = "Cancel")
    private WebElement cancelButton;

    @FindBy(xpath = "(//h1)[2]")
    private WebElement subTitile;










   @FindBy(xpath = "//label[text()='Description']/following-sibling::div//div")
   private WebElement descriptionInput;

    public void enterCalendarEventTitle(String titleValue) throws InterruptedException {
        Browserutils.waitForPageToLoad(20);

        wait.until(ExpectedConditions.visibilityOf(title));
        title.sendKeys(titleValue);
        Thread.sleep(5000);
    }

    public void enterCalendarEventDescription(String description) {
        //wait until frame is available and switch to it
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(descriptionFrame));
        textInputArea.sendKeys(description);
        driver.switchTo().defaultContent();//exit from the frame
    }



    public void clickAndSave() throws InterruptedException {
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOf(saveAndClose));
        wait.until(ExpectedConditions.elementToBeClickable(saveAndClose)).click();
        Thread.sleep(5000);


}
public String getInputTitle(){
        wait.until(ExpectedConditions.visibilityOf(actualTitleInput));
        return actualTitleInput.getText();
}

public String getDescription(){
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Description']/following-sibling::div//div")));
        return descriptionInput.getText();
}


    public void createCalenderEvent(){
        Browserutils.waitForPageToLoad(20);
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

public List<String> getColumnNames(){
        Browserutils.waitForPageToLoad(20);
        return Browserutils.getTextFromWebElements(columnNames);
}



public void deselectCheckBoxes(){
    Browserutils.waitForPageToLoad(20);
    gridSetting.click();
    Browserutils.wait(2);
    Checkbox2.click();
    Checkbox3.click();
    Checkbox4.click();
    Checkbox5.click();
    Checkbox6.click();
    Checkbox7.click();
    Browserutils.wait(2);
      closeSign.click();

}

public WebElement displayedColumn(){
        Browserutils.wait(2);
        return titleColumn;
}


public void clickExtendSaveAndClose(){
    Browserutils.waitForPageToLoad(20);
    Browserutils.wait(3);
    wait.until(ExpectedConditions.elementToBeClickable(extendSaveAndClose)).click();

        Browserutils.wait(3);
}


    public List<String> getDropDownOption(){
        Browserutils.waitForPageToLoad(20);
        return Browserutils.getTextFromWebElements(extendOptions);
    }


public  void clickCancelButton(){
    Browserutils.waitForPageToLoad(20);
    wait.until(ExpectedConditions.elementToBeClickable(cancelButton)).click();
        Browserutils.wait(3);
}

public WebElement getSubTitle(){
        return subTitile ;
}













}
