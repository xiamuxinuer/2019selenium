package Day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class basicTestNGTest {

    @BeforeMethod
    public void setUp(){
        System.out.println("before method");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("after method");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("before class ");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("after class");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("before test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("after test");
    }








    @Test
   public  void test1(){
        System.out.println("test1");
       String expected="apple";
       String actual="apple";
       Assert.assertEquals(actual,expected);
   }
@Test
public void test2(){
    System.out.println("test2");
        int  num1=5;
        int  num2=10;
        Assert.assertTrue(num1<num2);
}








}
