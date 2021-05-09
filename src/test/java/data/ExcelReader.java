package data;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    static FileInputStream file = null;

    public FileInputStream getFileInputStream()
    {
        String filePath = System.getProperty("user.dir")+"/src/test/java/data/userData.xlsx";
        File srcFile = new File(filePath);
        try {
            file = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            System.out.println("Error :"+e.getMessage());
        }
        return file;
    }

    public Object [][] getExcelDataSheet1() throws IOException {
        int TotalNumberOfRows,TotalNumberOfCols=2;

        file = getFileInputStream();

            XSSFWorkbook workbook =new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            TotalNumberOfRows = sheet.getLastRowNum()+1;
            String [][] ExcelData = new String[TotalNumberOfRows][TotalNumberOfCols];

            for (int i = 0; i < TotalNumberOfRows ; i++) {
                for (int j = 0; j < TotalNumberOfCols; j++) {

                    XSSFRow rows =sheet.getRow(i);
                    ExcelData[i][j]= rows.getCell(j).toString();
                }
            }
            workbook.close();

        return ExcelData;
    }


    public Object [][] getExcelDataSheet2() throws IOException {
        int TotalNumberOfRows=7,TotalNumberOfCols=2;

        file = getFileInputStream();

        XSSFWorkbook workbook =new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(1);
        TotalNumberOfRows = sheet.getLastRowNum()+1;
        String [][] ExcelData = new String[TotalNumberOfRows][TotalNumberOfCols];

        for (int i = 0; i < TotalNumberOfRows ; i++) {
            for (int j = 0; j < TotalNumberOfCols; j++) {

                XSSFRow rows =sheet.getRow(i);
                ExcelData[i][j]= rows.getCell(j).toString();
            }
        }
        workbook.close();

        return ExcelData;
    }

    public Object [][] getExcelData() throws IOException {
        int TotalNumberOfRows=1,TotalNumberOfCols=2;

        file = getFileInputStream();

        XSSFWorkbook workbook =new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        String [][] ExcelData = new String[TotalNumberOfRows][TotalNumberOfCols];

        for (int i = 0; i < TotalNumberOfRows ; i++) {
            for (int j = 0; j < TotalNumberOfCols; j++) {

                XSSFRow rows =sheet.getRow(i);
                ExcelData[i][j]= rows.getCell(j).toString();
            }
        }
        workbook.close();

        return ExcelData;
    }
    public Object [][] getCheckOutData() throws IOException {
        int TotalNumberOfRows,TotalNumberOfCols=5;

        file = getFileInputStream();

        XSSFWorkbook workbook =new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(2);
        TotalNumberOfRows = sheet.getLastRowNum()+1;
        String [][] ExcelData = new String[TotalNumberOfRows][TotalNumberOfCols];

        for (int i = 0; i < TotalNumberOfRows ; i++) {
            for (int j = 0; j < TotalNumberOfCols; j++) {

                XSSFRow rows =sheet.getRow(i);
                ExcelData[i][j]= rows.getCell(j).toString();
            }
        }
        workbook.close();

        return ExcelData;
    }
}
