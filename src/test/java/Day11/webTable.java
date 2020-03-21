package Day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.DriverFactory;

import java.util.Arrays;
import java.util.List;

public class webTable {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        driver= DriverFactory.createDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    @Test
    public void getColumnNames(){
        List<WebElement> columnNames=driver.findElements(By.xpath("//*[@id=\"table1\"]//thead//tr//th"));//or://table[1]//th
        List<String> expected = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        Assert.assertEquals(expected, utilities.webTable.getTextFromWebElements(columnNames));

        for (WebElement eachColumnName:columnNames){
            System.out.println(eachColumnName.getText());
        }

    }

@Test
    public void verifyRowCount(){
       List<WebElement> rows=driver.findElements(By.xpath("//table[1]//tbody//tr"));
    System.out.println(rows.size());  // number of rows
    Assert.assertEquals(rows.size(),4);
}

@Test
    public void getSpecificColumn(){
        //td[5] is column with links:
        List<WebElement> allLinks= driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
    //System.out.println(utilities.webTable.getTextFromWebElements(allLinks)); // give a list of string

    //or for each loop to print out each link separately:
    for (WebElement eachLink:allLinks){
        System.out.println(eachLink.getText());
    }
}


    /** TASK until 4:45
     * Go to tables example page
     * Delete record with jsmith@gmail.com email
     * verify that number of rows is equals to 3
     * verify that jsmith@gmail.com doesn't exists any more in the table
     */
@Test
    public void deleteRecord(){
    driver.findElement(By.xpath("//table[1]//tbody//tr[1]//td[5]//following-sibling::td/a[2]")).click();
    List<WebElement> rows=driver.findElements(By.xpath("//table[1]//tbody//tr"));

    Assert.assertEquals(rows.size(),3);

   Assert.assertTrue(driver.findElements(By.xpath("//*[@id=\"table1\"]/tbody/tr[1]/td[text()='jsmith@gmail.com']")).isEmpty());
//or
    List<WebElement> elements=driver.findElements(By.xpath("//*[@id=\"table1\"]/tbody/tr[1]/td[text()='jsmith@gmail.com']"));
    Assert.assertTrue(elements.isEmpty());
    //or
    System.out.println(elements.size());
    Assert.assertTrue(elements.size()==0);
}

@Test
    public void getColumnIndexByName(){

    String columnName="Email";

    List<WebElement> allColumnNames= driver.findElements(By.xpath("//table[2]//th"));
    int index=0;
    for (int i=0; i< allColumnNames.size();i++){
        if (allColumnNames.get(i).getText().equals(columnName)){
            index=i+1;
            break;
        }
    }
    Assert.assertEquals(index,3);
    }


    @Test
    public void getSpecificCell(){
    int row=3;
    int column=5;
    String xpath="//table[1]//tbody//tr[" + row + "]//td[" + column + "]";

    WebElement cell= driver.findElement(By.xpath(xpath));
        //System.out.println(cell.getText());
        String actual=cell.getText();
        String expected="http://www.jdoe.com";
        Assert.assertEquals(actual,expected);
}











}
