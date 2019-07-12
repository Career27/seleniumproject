package com.java;

import org.apache.commons.io.FileUtils;
import org.apache.xml.serializer.ToStream;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class countNumberofFiles {

    public static void main(String[] args) throws IOException {
        int count = new File("D:\\enterprise automation\\downloads").list().length;
        System.out.println("Number of file : " + count);


//        Path temp = Files.move(Paths.get("C:\\enterprise automation\\downloads\\*.*"), Paths.get("C:\\enterprise automation\\downloads\\done\\*.*"));


        /* Create source directory instance. */
        File srcDirFile = new File("D:\\enterprise automation\\downloads\\SKR-Test-05061045-FTSE 350-GBP-20190331-Default Excel Report.xlsx");

        /* Create target directory instance. */
        File destDirFile = new File("D:\\enterprise automation\\downloads\\done");

        /* Move directory to directory. */
        /* The third parameter is true means create target directory if not exist. */
//        FileUtils.moveFileToDirectory(srcDirFile, destDirFile, true);


        File dir1 = new File("D:\\enterprise automation\\downloads");
        if(dir1.isDirectory()) {
            File[] content = dir1.listFiles();
            for(int i = 0; i < content.length; i++) {
                //move content[i]
                System.out.println(content[i]);
                String srcFile = content[i].toString();

                File sourceFile = new File(content[i].toString());
                File destinationDir = new File("D:\\enterprise automation\\done");
                FileUtils.moveFileToDirectory(sourceFile,destinationDir,true);
            }
        }

    }
}
