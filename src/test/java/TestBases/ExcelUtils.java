package TestBases;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils extends TestBase{
    public static Object[][] readExcelData(String filePath, String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getLastRowNum();
        int columnCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount][columnCount];

        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i + 1);
            for (int j = 0; j < columnCount; j++) {
                Cell cell = row.getCell(j);
                data[i][j] = cell.toString();
            }
        }

        workbook.close();
        file.close();

        return data;
    }

    public static void writeExcelData(String filePath, String sheetName, Object[][] data) throws IOException {
        Workbook workbook = WorkbookFactory.create(true);
        Sheet sheet = workbook.createSheet(sheetName);

        int rowCount = data.length;
        int columnCount = data[0].length;

        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < columnCount; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(data[i][j].toString());
            }
        }

        FileOutputStream file = new FileOutputStream(filePath);
        workbook.write(file);

        workbook.close();
        file.close();
    }


}


/*

    then go to test ->dataProvider="MyData" and pass it into string and same for fields
    @DataProvider
    public Object[][] MyData(){
        Object[][]  data = new Object[1][1];
        data[0][0]="";
        data[0][1]="";
        data[1][0]="";
        data[1][1]="";
        return data;
    }
*/



//read from
/*
public class ExampleTest {
    public static void main(String[] args) throws IOException {
        // Set the path to your Excel file
        String filePath = "path/to/TestData.xlsx";
        String sheetName = "Sheet1";

        // Read the data from the Excel file
        Object[][] testData = ExcelUtils.readExcelData(filePath, sheetName);

        // Example usage: Perform actions using the test data
        WebDriver driver = new ChromeDriver();

        for (Object[] data : testData) {
            String username = data[0].toString();
            String password = data[1].toString();

            // Perform actions with the username and password
            // ...
        }

        driver.quit();
    }
}*/

//write to

/*
public class ExampleTest {
    public static void main(String[] args) throws IOException {
        // Set the path to your Excel file
        String filePath = "path/to/TestData.xlsx";
        String sheetName = "Sheet1";

        // Example data to be written to the Excel file
        Object[][] testData = {
                {"John Doe", "john@example.com"},
                {"Jane Smith", "jane@example.com"}
        };

        // Write the data to the Excel file
        ExcelUtils.writeExcelData(filePath, sheetName, testData);
    }
}*/


/*
@DataProvider
public void testData(){
    Object data[][] = TestUtils.getDataFromExcel("sheetname");
    return data;
}*/


