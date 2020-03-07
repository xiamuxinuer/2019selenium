package utilities;

public class Browserutils {

    // thread.sleep method:
   public static void wait(int second){

      try {
          Thread.sleep(1000*second);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
   }








}
