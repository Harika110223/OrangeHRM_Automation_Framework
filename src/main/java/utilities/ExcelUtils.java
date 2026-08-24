package utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    private static final String FILE_PATH="src/test/Sample TestData.xlsx";
    public static Object[][]getSheetData(String SheetName){
        Object[][]data=null;
        try (FileInputStream fis=new FileInputStream(new File(FILE_PATH));
            Workbook wb= WorkbookFactory.create(fis)) {
            Sheet sheet = wb.getSheet("Sheet1");
            int totalrows = sheet.getLastRowNum();
            int totalcol = sheet.getRow(0).getLastCellNum();
            data = new Object[totalrows][totalcol];
            for (int i = 1; i <= totalrows; i++) {
                var row = sheet.getRow(i);
                for (int j = 1; j < totalcol; j++) {
                    var cell = row.getCell(j);
                    data[i - 1][j] = (cell == null) ? "" : cell.toString();
                }
            }
        }catch(IOException e){
            System.err.println("Could not read file at: " + FILE_PATH);
            e.printStackTrace();

            }
return data;
    }
}
