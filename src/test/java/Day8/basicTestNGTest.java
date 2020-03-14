package Day8;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class basicTestNGTest {

    @BeforeMethod
    public void setUp(){
        System.out.println("before method");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("after method");
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
