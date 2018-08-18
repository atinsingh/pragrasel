package co.pragra.selframework.utils;

import co.pragra.selframework.config.TestConfig;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static String[] getToken(String str, String regex){
        String data[] = new String[2];
         data[0] = str.substring(0,str.indexOf(regex));
         data[1] = str.substring(str.indexOf(regex)+1, str.length());
         return data;
    }

    public static String getFileName(String testName){
        Date date  = new Date();
        SimpleDateFormat format = new SimpleDateFormat("ddMMyyyyHHmmss");
        return testName+"_"+format.format(date)+".png";
    }

}
