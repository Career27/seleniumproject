package com.dlg.web.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportsClass extends TestBaseExtentReport {

    //    @Test(description = "This a verify title test on google page", timeOut =200 , priority = 1, dependsOnMethods = "", groups ="", enabled = true, alwaysRun=true)
    @Test(description = "Verify title on google page")
    public void Verify_title_on_the_google_page() {
//        Test test = method.getAnnotation(Test.class);
//        logger = extent.createTest(test.description());
        Assert.assertEquals(driver.getTitle(), "Googles");
//        System.out.println("Test Name - " +test.testName());
//        System.out.println("Test Description is - "+test.description());
    }

    @Test
    public void verify_Logo_on_google_page() {
//        logger = extent.createTest("To verify Google Logo");
        boolean img = driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();
        logger.createNode("Image is Present");
        Assert.assertTrue(img);
        logger.createNode("Image is not Present");
        Assert.assertFalse(img);
    }


}
