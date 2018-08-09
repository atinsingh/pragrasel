package co.pragra.selframework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SelectorConfig {
    private static Properties properties;

    private SelectorConfig(){
        try{
            //getClass().getClassLoader().getResource("config/driver.config");
            InputStream in = new FileInputStream("/Users/atinsingh/OneDrive/pragra/selframework/src/test/resources/config/selector" +
                    ".config");
            properties = new Properties();
            properties.load(in);
        }catch (IOException ex){
            System.out.println("Exception in reading file");
        }
    }

    public static String getProperty(String key){
        if(properties == null){
            new SelectorConfig();
        }
        return properties.getProperty(key);
    }
}
