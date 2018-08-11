package co.pragra.selframework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class DriverConfig {
    private static Properties properties;

    protected DriverConfig(){
        try{
           Path path =   Paths.get("src","test","resources","config", "driver.config");
            System.out.println(path.toAbsolutePath());
            //InputStream in = new FileInputStream(path.toAbsolutePath().toString());
            InputStream in = new FileInputStream(path.toFile());
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
