package Day13;

import org.testng.annotations.Test;

public class SystemPropertiesPractice {
    @Test
    public void test1(){
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("os.arch"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("java.version"));

    }

@Test
    public void  test2(){
       String pathDownLoads=System.getProperty("user.home") + "\\Downloads";
    System.out.println(pathDownLoads);




}













}
