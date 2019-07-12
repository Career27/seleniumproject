package com.dlg.web.test;

import com.dlg.utilities.*;
import com.dlg.web.env.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class enterpriseDownloadReport implements BaseTest {


    @Test
    public void reportDownload_Test() throws InterruptedException, IOException ,  Exception{

        String WEB_URL = requtil.getEnvPropertyValue("WEB_URL");
        driver.get(WEB_URL);

        Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        System.out.println(browserName);
        String os = cap.getPlatform().toString();
        System.out.println(os);
        String v = cap.getVersion().toString();
        System.out.println(v);


        WebElement inputUsername = driver.findElement(By.xpath("//*[@id='ctl00_bodyContentPlaceholder_UserLogin_UserName']"));
        inputUsername.clear();
        inputUsername.sendKeys("suraj.kumar@styleanalytics.com");

        HighlightElement.highLight(inputUsername);

        WebElement inputPassword = driver.findElement(By.xpath("//*[@id='ctl00_bodyContentPlaceholder_UserLogin_Password']"));
        inputPassword.clear();
        inputPassword.sendKeys("Test12345!");

        WebElement btnLogin = driver.findElement(By.xpath("//*[@id='ctl00_bodyContentPlaceholder_UserLogin_LoginButton']"));
        btnLogin.click();

        WebElement menuPortfolioReports = driver.findElement(By.id("hlPortfolioReports"));
        menuPortfolioReports.click();

        WebElement menuHamburger = driver.findElement(By.xpath("//*[@id='rhsHamb']"));
        menuHamburger.click();

        Thread.sleep(5000);

        WebElement menuHambugerDownload = driver.findElement(By.xpath("//*[@class='menuOptionText'] [contains(text(),'Download')]"));
        menuHambugerDownload.click();

        By locIframe = By.xpath("//iframe[@name='radWindowStyleExposureSettings']");
        driver.switchTo().frame(driver.findElement(locIframe));

        String templateName = "Default Excel Report";

        driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_txtFilter']")).sendKeys(templateName);

//        WebElement btnFilter = driver.findElement(By.id("ctl00_mainContentPlaceHolder_cmdFilter"));
//        btnFilter.click();
        driver.findElement(By.xpath("//*[@id='ctl00_mainContentPlaceHolder_cmdFilter_input']")).click();
        Thread.sleep(5000);
        HighlightElement.highLight(driver.findElement(By.xpath("//a[text()='" + templateName + "']")));

        driver.findElement(By.xpath("//a[text()='" + templateName + "']")).click();

        Date startTime = new Date(System.currentTimeMillis());

        driver.switchTo().defaultContent();
        System.out.println("downloading report ........" );

//        HighlightElement.highLight(driver.findElement(By.xpath("//a[@class='rwCloseButton']")));
        driver.findElement(By.xpath("//a[@class='rwCloseButton']")).click();
        WinFileExploreUtil.moveFilesToFolder("D:\\enterprise automation\\downloads","D:\\enterprise automation\\downloads_done");

        System.out.println("previously downloaded files moved successfully to D:\\enterprise automation\\downloads_done ........" );

        System.out.println("waiting for the report to be downloaded ........" );
        for (int i = 0; i < 50; i++) {
            Thread.sleep(4000);

            if(browserName.equals("internet explorer")){RobotUtil.saveFile();}
            Thread.sleep(2000);
            int noOfFiles = WinFileExploreUtil.CountNumberOfFiles("D:\\enterprise automation\\downloads");
            if (noOfFiles != 1 ){
                continue;
            } else {
                System.out.println("report downloaded successfully........" );
                break;
            }
        }
        Date endTime = new Date(System.currentTimeMillis());

        System.out.println(Common.timeDifference(startTime,endTime));

        String actualReport = WinFileExploreUtil.findDownloadedReportName("D:\\enterprise automation\\downloads");
        String expectedReport =  "D:\\enterprise automation\\expected-reports\\SKR-Test-05061045-FTSE 350-GBP-20190331-Default Excel Report.xlsx";
        List<String> compExcelResults = new ArrayList<>();

        System.out.println("comparing excel report........");
        compExcelResults = ExcelFileCompare.Comparator(expectedReport,actualReport);
        System.out.println("comparing excel report completed........");

        for(String a:compExcelResults){
            System.out.println(a);
        }


//
//        Assert.assertEquals("09 FEB 2022 : 16 : 26", coverStartDate);
//
//
//        Assert.assertEquals("18 FEB 2022 : 23 : 59", coverEndDate);

        driver.close();

    }
}
