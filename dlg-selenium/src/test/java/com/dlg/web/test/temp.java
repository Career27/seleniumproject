package com.dlg.web.test;

import com.dlg.utilities.ExcelFileCompare;
import com.zeonpad.pdfcompare.ZPDFColorConstant;
import com.zeonpad.pdfcompare.ZPDFCompare;
import org.apache.commons.io.FileExistsException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class temp {
    public static void main(String[] args) throws Exception {

//        List<String> result = new ArrayList<>();
//
//        result = ExcelFileCompare.Comparator("D:\\enterprise automation\\Capped.xlsx","D:\\enterprise automation\\Truncated.xlsx");
//
//        for(String a: result){
//            System.out.println(a);}
//

//        Date startTime = new Date(System.currentTimeMillis());
//        Thread.sleep(5464);
//        Date endTime = new Date(System.currentTimeMillis());
//
//
//        long diff = endTime.getTime() - startTime.getTime();
//        long diffSeconds = diff / 1000;
////        long diffMinutes = diff / (60 * 1000);
////        long diffHours = diff / (60 * 60 * 1000);
////        System.out.println("Time in seconds: " + diffSeconds + " seconds.");
////        System.out.println("Time in minutes: " + diffMinutes + " minutes.");
////        System.out.println("Time in hours: " + diffHours + " hours.");
//
//        System.out.println("File downloaded in "+Math.floorDiv(diffSeconds, 60)+" mins and "+Math.floorMod(diffSeconds, 60)+" sec");

//        List<String> output = new ArrayList<>();
//        output = ExcelFileCompare.Comparator("D:\\enterprise automation\\Capped.xlsx","D:\\enterprise automation\\Truncated.xlsx");
//
//        FileWriter writer = new FileWriter("D:\\enterprise automation\\output.txt");
//        for(String str : output) {
//            writer.write(str);
//        }
//        writer.close();

        ExcelFileCompare.Comparator("D:\\enterprise automation\\Capped.xlsx","D:\\enterprise automation\\Truncated.xlsx","D:\\enterprise automation\\output.txt");

//        String expectedFile = "D:\\enterprise automation\\downloads\\Capture.pdf";
//        String actualFile = "D:\\enterprise automation\\downloads\\Capture1.pdf";
//        String diffOutputFile = "D:\\enterprise automation\\downloads\\diffOutfile.pdf";
//        String actualFileDiff = "D:\\enterprise automation\\downloads\\actualfilediff.pdf";
//
//        ZPDFCompare obj = new ZPDFCompare();
//        obj.pdfcompare(expectedFile,actualFile,diffOutputFile,actualFileDiff);


    }
}
