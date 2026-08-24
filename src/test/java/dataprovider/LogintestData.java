package dataprovider;

import org.testng.annotations.DataProvider;
import utilities.ExcelUtils;

public class LogintestData {
    @DataProvider(name = "loginExcelData" ,parallel=true)
    public Object[][] getLoginData() {
        Object[][] rawData = ExcelUtils.getSheetData("Sheet1");


        // Loop through the data in memory to sanitize any potential null cells
        for (int i = 0; i < rawData.length; i++) {
            for (int j = 0; j < rawData[i].length; j++) {
                if (rawData[i][j] == null) {
                    rawData[i][j] = ""; // Safely swap null for empty string
                }
            }
        }
        return rawData;
    }
}