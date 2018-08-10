package co.pragra.selframework.testdata;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ExcelReader {
    // Where is my excel file
    private String filename;
    private List<Object[]> testData;

    public ExcelReader(String filename) {
        this.filename = filename;
        this.testData = new ArrayList<>();
        try {
            FileInputStream inputStream = new FileInputStream(new File(filename));
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet contactTestSheet = workbook.getSheet("ContactTest");
            Iterator<Row> rows = contactTestSheet.iterator();

            //loop trough all rows
            rows.next();
            while (rows.hasNext()){
                Row currentRow = rows.next();
                Iterator<Cell> cells = currentRow.iterator();
                List<String> celllist = new ArrayList<>();
                while(cells.hasNext()){
                    Cell currentCell = cells.next();
                    celllist.add(currentCell.getStringCellValue());
                    System.out.println(currentCell.getStringCellValue());
                }
                testData.add(celllist.toArray());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public List<Object[]> getTestData() {
        return testData;
    }
}


