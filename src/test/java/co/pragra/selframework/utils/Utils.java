package co.pragra.selframework.utils;

public class Utils {

    public static String[] getToken(String str, String regex){
        String data[] = new String[2];
         data[0] = str.substring(0,str.indexOf(regex));
         data[1] = str.substring(str.indexOf(regex)+1, str.length());
         return data;
    }

}
