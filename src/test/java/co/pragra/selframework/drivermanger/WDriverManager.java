package co.pragra.selframework.drivermanger;

import co.pragra.selframework.config.TestConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WDriverManager {

    private static WebDriver webDriver;

    private WDriverManager(){
        webDriver = createDriverInstance();
    }

    private WebDriver createDriverInstance(){
        System.setProperty("webdriver.chrome.driver",TestConfig.getProperty("chrome.executable.path"));

        if(TestConfig.getProperty("gecko.executable.path")!=null){
            System.setProperty("webdriver.gecko.driver",TestConfig.getProperty("gecko.executable.path"));
        }
        if(TestConfig.getProperty("ie.executable.path")!=null) {
            System.setProperty("webdriver.ie.driver", TestConfig.getProperty("ie.executable.path"));
        }

        if(TestConfig.getProperty("browser.type").equalsIgnoreCase("chrome")){
            return new ChromeDriver();
        }else
            if(TestConfig.getProperty("browser.type").equalsIgnoreCase("firefox")){
                return new FirefoxDriver();
            }else {
                return new InternetExplorerDriver();
            }
    }

    public static WebDriver getInstance(){
        if(webDriver == null){
            new WDriverManager();
        }
        return webDriver;
    }

}
