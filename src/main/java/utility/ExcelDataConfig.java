package utility;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

import java.io.File;
import java.io.FileInputStream;

public class ExcelDataConfig {

    HSSFWorkbook wb;
    HSSFSheet sheet1;
    //XSSFWorkbook wb;
    //XSSFSheet sheet1;
    String path;

    public ExcelDataConfig(String excelPath) {

        try {

            File src = new File(excelPath);

            FileInputStream fis = new FileInputStream(src);

            //wb=new XSSFWorkbook(fis);
            wb = new HSSFWorkbook(fis);

            path = excelPath;

        } catch (Exception e) {

            System.out.println(e.getMessage());

        }

    }

    public String getData(String sheetName, int row, int column) {

        sheet1 = wb.getSheet(sheetName);

        DataFormatter df = new DataFormatter();

        String stringdata = df.formatCellValue(sheet1.getRow(row).getCell(column));

        return stringdata;

    }

    public int getRowCount(String sheetName) {

        int row = wb.getSheet(sheetName).getLastRowNum();
        row = row + 1;

        return row;

    }

    public int getColumnCount(String sheetName) {

        int columncount = wb.getSheet(sheetName).getRow(0).getLastCellNum();

        return columncount;

    }

    public int getSheetCount() {

        int sheetcount = wb.getNumberOfSheets();

        return sheetcount;

    }

    public int getSheetIndex(String sheetName) {

        int sheetindex = wb.getSheetIndex(sheetName);

        return sheetindex;

    }

    public String getSheetName(int sheetIndex) {

        String sheetname = wb.getSheetName(sheetIndex);

        return sheetname;

    }

    public String getWorkbookName() {

        int lastbackslash = String.valueOf(path).toString().lastIndexOf("\\", String.valueOf(path).length());
        lastbackslash = lastbackslash + 1;  //To eliminate the final backslash character
        String workbookname = String.valueOf(path).toString().substring(lastbackslash);

        return workbookname;

    }

    public String getWorkbookPath() {

        int lastbackslash = String.valueOf(path).toString().lastIndexOf("\\", String.valueOf(path).length());
        lastbackslash = lastbackslash + 1;  //To eliminate the final backslash character
        String workbookpath = String.valueOf(path).toString().substring(0, lastbackslash);

        return workbookpath;

    }
}

