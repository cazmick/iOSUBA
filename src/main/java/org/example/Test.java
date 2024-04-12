package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class Test {

    public String ReadExcel2010AndCreateQuery(String excelFilePathWithFileName, int excelColumnLength) {
        try {

//Load excel file content into memory
//excel processing start
            FileInputStream file = new FileInputStream(new File(excelFilePathWithFileName));

//constructor call
            XSSFWorkbook workbook = new XSSFWorkbook(file);

//Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            String tableName = sheet.getSheetName(); //it's actually our table name
            String columnNamesPlaceHolder = "£££";
            String columnValuesPlaceHolder = "$$";

// insert into tablename(column1,column2) values (1,2)
            String insertQueryTemplate = String.format("INSERT INTO " + tableName + "(" + columnNamesPlaceHolder + ") VALUES (" + columnValuesPlaceHolder + ");");

//To store each created insert query
            StringBuilder allInsertQueriesList = new StringBuilder();

//to store our column name for ex: columnName1, column Name2…..so on
            StringBuilder columnNamesBuilder = new StringBuilder();

//Iterate through each row in excel sheet one by one
            Iterator<Row> rowIterator = sheet.iterator();
            int currentRow = 1;

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                String tempInsertQueryTemplate = "";//only declaration
                StringBuilder currentRowValuesBuilder = null;//only declaration

                if (currentRow > 1) {

                    tempInsertQueryTemplate = insertQueryTemplate; /// Insert into tableName (columnName1, columnName2) values ( '$
                }
            }
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        return excelFilePathWithFileName;
    }
}
