package TestNGPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {

    public static String reverseString(String str){

        String reversed="";

        for (int i =str.length()-1; i>=0; i--) {
            reversed+=str.charAt(i);
        }
        return reversed;
    }

    public static Boolean verifyEquals(String expected, String actual){
        if (expected.equals(actual)){
            System.out.println("test passed");
            return true;
        }
        else {
            System.out.println("test failed");
            System.out.println("expected  "+ expected);
            System.out.println("eactual  "+  actual);
            return false;
        }
    }








    //annotation
    @Test(description = "verify if method can reverse a string") //(description only work for test NG, NOt work on Junit)
    public void test(){

        String expected="elppa";
        String actual=reverseString("apple");
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void test2(){
        String expected="rac";
        String actual=reverseString("car");
        Assert.assertEquals(actual,expected);
    }









    public static void main(String[] args) {

        System.out.println(reverseString("apple"));


        String expected="avaj";
        String toReverse="java";
        String reversed=reverseString(toReverse);

        System.out.println(verifyEquals(expected,reversed));




    }



}
