package co.pragra.selframework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DriverConfig {
    private static Properties properties;

    protected DriverConfig(){
        try{
            //getClass().getClassLoader().getResource("config/driver.config");
            InputStream in = new FileInputStream("C:/Users/shuchi/git/pragrasel/src/test/resources/config/driver.config");
            properties = new Properties();
            properties.load(in);
        }catch (IOException ex){
            System.out.println("Exception in reading file");
        }
    }

    public static String getProperty(String key){
        if(properties == null){
            new DriverConfig();
        }
        return properties.getProperty(key);
    }
}
