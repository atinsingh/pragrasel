package co.pragra.selframework.drivermanger;

import co.pragra.selframework.config.DriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager(){
            //initializeSystemProperty();
        System.out.println("Initializing driver instance with following properties  " + DriverConfig.getProperty("chrome.executable.path"));
        System.setProperty("webdriver.chrome.driver", DriverConfig.getProperty("chrome.executable.path"));
        if(DriverConfig.getProperty("browser.type").equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
        }else{
            driver = new ChromeDriver();
        }
    }

//    //enum
//    private void initializeSystemProperty(){
//
//    }

    public static WebDriver getDriver(){
        if(driver==null){
            new DriverManager();
        }
        return driver;
    }
}
