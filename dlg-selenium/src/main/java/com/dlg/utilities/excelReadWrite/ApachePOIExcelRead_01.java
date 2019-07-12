package com.dlg.utilities.excelReadWrite;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ApachePOIExcelRead_01 {

    private static final String FILE_NAME = "C:\\ExcelUtility\\testData.xlsx";

    public static void main(String[] args) {

        try {

            DataFormatter formatter = new DataFormatter();
            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook wb = new XSSFWorkbook(excelFile);

            Sheet sheet1 = wb.getSheetAt(0);
            for (Row row : sheet1) {
                for (Cell cell : row) {

                    CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
//                    System.out.print(cellRef.formatAsString());
//                    System.out.print(" - ");

                    // get the text that appears in the cell by getting the cell value and applying any data formats (Date, 0.00, 1.23e9, $1.23, etc)
                    String text = formatter.formatCellValue(cell);
//                    System.out.print(text);
                    if (cell.getCellType() == CellType.STRING) {
                        System.out.print(cellRef.formatAsString()+"-"+cell.getRichStringCellValue().getString()+"--");
                    } else if (cell.getCellType() == CellType.NUMERIC) {

                        if (DateUtil.isCellDateFormatted(cell)) {
                            System.out.print(cellRef.formatAsString()+"-"+cell.getDateCellValue()+"--");
                        } else {
                            System.out.print(cellRef.formatAsString()+"-"+cell.getNumericCellValue()+"--");
                        }
                    } else if (cell.getCellType() == CellType.BOOLEAN) {
                        System.out.print(cellRef.formatAsString()+"-"+cell.getBooleanCellValue()+"--");
                    } else if (cell.getCellType() == CellType.FORMULA) {
                        System.out.print(cellRef.formatAsString()+"-"+cell.getCellFormula()+"--");

                    } else if (cell.getCellType() == CellType.BLANK) {
                        System.out.print(cellRef.formatAsString()+"-"+"blank"+"--");
                    } else {
                        System.out.print(cellRef.formatAsString()+"-"+"cell type not found"+"--");
                    }

//                    // Alternatively, get the value and format it yourself
//                    switch (cell.getCellType()) {
//                        case CellType.STRING:
//                            System.out.println(cell.getRichStringCellValue().getString());
//                            break;
//                        case CellType.NUMERIC:
//                            if (DateUtil.isCellDateFormatted(cell)) {
//                                System.out.println(cell.getDateCellValue());
//                            } else {
//                                System.out.println(cell.getNumericCellValue());
//                            }
//                            break;
//                        case CellType.BOOLEAN:
//                            System.out.println(cell.getBooleanCellValue());
//                            break;
//                        case CellType.FORMULA:
//                            System.out.println(cell.getCellFormula());
//                            break;
//                        case CellType.BLANK:
//                            System.out.println();
//                            break;
//                        default:
//                            System.out.println();
//                    }
                }
                System.out.println();
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}