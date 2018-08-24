package co.pragra.selframework.testdata;

import org.apache.commons.exec.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FlatFileReader {
    private String fileName = Paths.get("src","test","resources/testdata","flatfile.txt").toString();
    private BufferedReader reader;

    public FlatFileReader() {
        try {
            File flatFile = new File(fileName);

            //BufferredReader it readfile content as binary buffer
            FileReader fileReader = new FileReader(flatFile);
            reader = new BufferedReader(fileReader);

        }catch (IOException ex){
            System.out.println("Something went wrong");
        }

    }

    /**
     * A dataprovider should return one of the following
     *  Either Object[][]
     *  or Iterator<Object[]>
     * @return
     */

    public List<Object[]> getFlatFileData(){
        List<Object[]> objectList = new ArrayList<>();
        String st;
        try {
            reader.readLine();
            while((st = reader.readLine()) !=null){
                String [] token = StringUtils.split(st,"|");
                objectList.add(token);

            }
        }catch (NullPointerException|IOException ex){
            System.out.println("Got something wierd in the reading file lines");
        }
        return objectList;

    }
}
