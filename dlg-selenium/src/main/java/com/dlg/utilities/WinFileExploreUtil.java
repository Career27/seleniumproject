package com.dlg.utilities;

import org.apache.commons.io.FileExistsException;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class WinFileExploreUtil {

    public static int CountNumberOfFiles(String folderPath) {
        int noOfFiles = new File(folderPath).list().length;
        return noOfFiles;
    }

    public static void moveFilesToFolder(String srcDir, String destDir) throws IOException {
        File dir1 = new File(srcDir);
        if (dir1.isDirectory()) {
            File[] content = dir1.listFiles();
            for (int i = 0; i < content.length; i++) {
                //move content[i]
//                System.out.println(content[i]);
                String srcFile = content[i].toString();
//                System.out.println(srcFile);
                File sourceFile = new File(content[i].toString());
                File destinationDir = new File(destDir);
                try {
                    FileUtils.moveFileToDirectory(sourceFile, destinationDir, true);
                } catch (FileExistsException e) {
                    File deleteFile = new File(destDir + "\\" + content[i].getName());
                    FileUtils.forceDelete(deleteFile);
                    FileUtils.moveFileToDirectory(sourceFile, destinationDir, true);
                }
            }
        }
    }

    public static String findDownloadedReportName(String dirPath) {
        String srcFile = "no file found";
        File dir1 = new File(dirPath);
        if (dir1.isDirectory()) {
            File[] content = dir1.listFiles();
//            System.out.println(content.length);
            if (content.length == 1) {
                srcFile = content[0].toString();
            } else if (content.length > 1) {
                System.out.println("more then one repots found at ....");
            }
        }
//        System.out.println(srcFile);
        return srcFile;
    }
}
