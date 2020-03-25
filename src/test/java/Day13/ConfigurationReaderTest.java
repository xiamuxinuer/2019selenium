package Day13;

import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.Driver;

public class ConfigurationReaderTest {

    @Test
    public void readProperties(){

String browser= ConfigurationReader.getProperty("browser");

        System.out.println(browser);
        String  url= ConfigurationReader.getProperty("qa1");
        System.out.println(url);
        String storeManager=ConfigurationReader.getProperty("store_manager");
        System.out.println(storeManager);
        String password=ConfigurationReader.getProperty("password");
        System.out.println(password);
        String driver= ConfigurationReader.getProperty("driver");
        System.out.println(driver);

        System.out.println(Driver.getDriver());
        Driver.closeDriver();

    }







}
