package com.java;

import com.dlg.utilities.ExcelFileCompare;

import java.util.ArrayList;
import java.util.List;

public class runMain {
    public static void main(String[] args) throws Exception{
        List<String> comparisionResult= new ArrayList<>();

        comparisionResult = ExcelFileCompare.Comparator("C:\\ExcelUtility\\SKR-Test-05061045-FTSE 350-GBP-20190331-Default Excel Report_Expectedl01.xlsx","C:\\ExcelUtility\\SKR-Test-05061045-FTSE 350-GBP-20190331-Default Excel Report_Actual01.xlsx");

//        System.out.println(comparisionResult);

        for(String a: comparisionResult){
            System.out.println(a);
        }


    }
}
