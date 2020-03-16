package Day9;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationForm {


    private WebDriver driver;
    private  String   URL="http://practice.cybertekschool.com/registration_form";

    private By firstNameBy = By.name("firstname");
    private By lastNameBy = By.name("lastname");
    private By usernameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneBy = By.name("phone");
    //gender
    private By maleBy = By.cssSelector("input[value='male']");
    private By femaleBy = By.cssSelector("input[value='female']");
    private By otherBy = By.cssSelector("input[value='other']");
    private By dateOfBirthBy = By.name("birthday");
    private By departmentBy = By.name("department");
    private By jobTitleBy = By.name("job_title");
    //languages
    private By cplusplusBy = By.xpath("//label[text()='C++']/preceding-sibling::input");
    private By javaBy = By.xpath("//label[text()='Java']/preceding-sibling::input");
    private By javascriptBy = By.xpath("//label[text()='JavaScript']/preceding-sibling::input");

    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

@AfterMethod
    public void tearDown(){
        driver.quit();
}

@Test
    public void test1() throws InterruptedException {
driver.findElement(firstNameBy).sendKeys("emma");
driver.findElement(lastNameBy).sendKeys("xiao");
driver.findElement(usernameBy).sendKeys("cybertekuser");
driver.findElement(emailBy).sendKeys("emma@gmail.com");
driver.findElement(passwordBy).sendKeys("majdjfikjklajakfj");
driver.findElement(phoneBy).sendKeys("405-332-2015");
driver.findElement(femaleBy).click();
driver.findElement(dateOfBirthBy).sendKeys("12/05/1998");
    Select selectDepartment=new Select(driver.findElement(departmentBy));
    selectDepartment.selectByValue("DE");

Select selectJobTitle=new Select(driver.findElement(jobTitleBy));
selectJobTitle.selectByVisibleText("Manager");

driver.findElement(javaBy).click();
driver.findElement(By.id("wooden_spoon")).click();
    Thread.sleep(5000);
    String message= driver.findElement(By.tagName("p")).getText();
    String  expected="You've successfully completed registration!";

    Assert.assertEquals(message,expected,"the message is not match");



    Thread.sleep(2000);
}

@Test(description = "verify first name length")
    public void test2() throws InterruptedException {
        driver.findElement(firstNameBy).sendKeys("d");
    Thread.sleep(3000);
        WebElement message= driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/small[2]"));
    Thread.sleep(2000);
Assert.assertTrue(message.isDisplayed());
}

@Test
    public void test3() throws InterruptedException {
    driver.findElement(firstNameBy).sendKeys("123");
    Thread.sleep(3000);
    WebElement message=driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/small[3]"));

    Assert.assertTrue(message.isDisplayed());
}















}
