package com.cybertek.test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelRead {
    public static void main(String[] args) throws Exception {


        File file=new File("src/SampleData.xlsx");
        //System.out.println(file.exists());

        //LOAD THE FILE INTO JAVA MEMORY
        FileInputStream fileInputStream=new FileInputStream(file);
        // Load the excel workbook into the java class
        XSSFWorkbook workbook=new XSSFWorkbook(fileInputStream);

        // workbook > sheet > row > cell

        // getting the sheet from the workbook
        XSSFSheet sheet=workbook.getSheet("Employees");

        //How to get Sandler from the excel sheet

        System.out.println(sheet.getRow(2).getCell(1));
        // row top to bottom 0,1,2.. cell left to right 0,1,2...

        int usedRows=sheet.getPhysicalNumberOfRows();
        System.out.println(usedRows);//5 ==> index 4
        //will count only the used cells
        // if there are some cells that are not used, they will not be counted
        // starts counting from 1

        int lastUsedRow=sheet.getLastRowNum();
        System.out.println(lastUsedRow);//4
        // will count from top to bottom
        // does not care if empty cell or used cell
        // this starts from 0

        // TODO: 1- CREATE THAT PRINTS OUT NEENA'S NAME DYNAMzICALLY
        for(int rowNum=0; rowNum<usedRows; rowNum++){
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Neena")){ //cell left to right indexes
                System.out.println("Neena's name: "+sheet.getRow(rowNum).getCell(0));
            }
        }


        // TODO: 2- CREATE A LOGIC THAT PRINTS OUT ADAM'S LAST NAME DYNAMICALLY
        for(int rowNum=0; rowNum<usedRows; rowNum++){
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Adam")){ //cell left to right indexes
                System.out.println("Adam's last name: "+sheet.getRow(rowNum).getCell(1));
            }
        }

        // TODO: 3- PRINTS OUT STEVEN'S JOB ID DYNAMICALLY
        for(int rowNum=0; rowNum<usedRows; rowNum++){
            if(sheet.getRow(rowNum).getCell(1).toString().equals("King")){ //cell left to right indexes
                System.out.println("King's JOB_ID: "+sheet.getRow(rowNum).getCell(2));
            }
        }


    }
}
