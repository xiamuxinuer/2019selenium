package Fleet_page;

import Fleet_page.AbstractPageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehiclesPage extends AbstractPageBase {
    @FindBy(partialLinkText = "Create Car")
    private WebElement createCar;

    public void clickToCreateCar() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(createCar)).click();
        Thread.sleep(3000);
    }











}
