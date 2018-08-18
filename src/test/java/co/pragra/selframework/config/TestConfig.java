package co.pragra.selframework.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class TestConfig {

    private static Properties properties;


    private TestConfig(){
        properties = new Properties();

        //Read the file ==> use inputStream
        Path path =   Paths.get("src","test","resources","config", "driver.config");
        try {
            InputStream stream = new FileInputStream(path.toFile());
            properties.load(stream);
        }catch (FileNotFoundException ex){
            System.out.println("Nothing to worry I wasn't able to find file");
        }catch (IOException ex){
            System.out.println("Couldn't load");
        }

    }



    public static String getProperty(Object key){
        if(properties == null){
            new TestConfig();
        }
       return (String)properties.get(key);
    }
}
