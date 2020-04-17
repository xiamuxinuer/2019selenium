package Vytrack_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Fleet_VehiclesPage extends AbstractPageBase {
    @FindBy(partialLinkText = "Create Car")
    private WebElement createCar;

    @FindBy(xpath = "(//h1)[2]")
    private WebElement subHeader;

    public void clickToCreateCar() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(createCar)).click();
        Thread.sleep(3000);
    }


    public String getSubHeader(){
        return subHeader.getText();
    }









}
