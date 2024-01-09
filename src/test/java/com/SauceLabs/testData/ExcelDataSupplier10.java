package com.SauceLabs.testData;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataSupplier10 {
 @DataProvider(name = "Login")
    public String[][] getdata() throws IOException {
   // public static void main(String[] args) throws IOException {
        File excelFile = new File("./src/test/java/com/SauceLabs/testData/Book2.xlsx");
        FileInputStream fis = new FileInputStream(excelFile);
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet2");
        int noOfRows = sheet.getPhysicalNumberOfRows();
       // System.out.println(noOfRows);//7
        int noOfColums=sheet.getRow(0).getLastCellNum();
       // System.out.println(noOfColums);//2
        String[][]data=new String[noOfRows-1][noOfColums];
        for(int i=0;i<noOfRows-1;i++){
            for(int j=0;j<noOfColums;j++){
                DataFormatter df= new DataFormatter();
                data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
            }
        }
        workbook.close();
        fis.close();
        return data;

    }
}
