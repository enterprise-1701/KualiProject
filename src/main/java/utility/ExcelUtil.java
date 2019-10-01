package utility;

import java.io.IOException;

public class ExcelUtil {

    private static String SHEET = "input";
    private static String FILE = "Input.xls";
    private static int rows;
    private static int columns;

    public String[][] readExcel(String filePath, String fileName, String sheetName) throws IOException {

        //Get number of rows and columns
        ExcelDataConfig config = new ExcelDataConfig(filePath + "\\" + fileName);
        rows = config.getRowCount(sheetName);
        columns = config.getColumnCount(sheetName);
        System.out.println("Number of rows: " + rows + " Number of columns: " + columns);

        //Store data in a two dimensional array
        String[][] excelData = new String[rows - 1][columns];
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                excelData[i - 1][j] = config.getData(SHEET, i, j);
            }
        }

        return excelData;

    }

    public int getRows(String filePath, String fileName, String sheetName) {
        ExcelDataConfig config = new ExcelDataConfig(filePath + "\\" + fileName);
        rows = config.getRowCount(sheetName);
        return rows;
    }

    public int getColumns(String filePath, String fileName, String sheetName) {
        ExcelDataConfig config = new ExcelDataConfig(filePath + "\\" + fileName);
        columns = config.getRowCount(sheetName);
        return columns;
    }

    //Test ExcelUtil
    public static void main(String... strings) throws IOException {

        ExcelUtil readExcelFile = new ExcelUtil();
        String filePath = System.getProperty("user.dir") + "\\InputFiles\\";
        String[][] myList = readExcelFile.readExcel(filePath, FILE, SHEET);
        System.out.println("Data Retrieved from Excel:");
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.println(myList[i - 1][j]);
            }
        }
    }
}



