package com.dlg.web.extentreport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBaseExtentReport {

    public WebDriver driver;
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest logger;

    @BeforeTest
    public void startReport() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/STMExtentReport.html");
        // Create an object of Extent Reports
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "Style Analytics");
        extent.setSystemInfo("Environment", "Staging");
        extent.setSystemInfo("User Name", "Suraj Kumar");
        htmlReporter.config().setDocumentTitle("Style Analytics - Enterprise test execution report ");
        // Name of the report
        htmlReporter.config().setReportName("Style Analytics - Enterprise test execution report ");
        // Dark Theme
        htmlReporter.config().setTheme(Theme.STANDARD);
//        htmlReporter.config().setAutoCreateRelativePathMedia(true);
    }

    //This method is to capture the screenshot and return the path of the screenshot.
    public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("ddMMyyyyddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        // after execution, you could see a folder "FailedTestsScreenshots" under src folder
//        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
//        String destination = "C:/Users/suraj/svn_workspace/seleniumproject/dlg-selenium"+"/Screenshots/" + screenshotName + dateName + ".png";
        String destination = System.getProperty("user.dir") + "\\test-output\\screenshots\\" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
//        return destination;
        return "screenshots/"+screenshotName + dateName + ".png";
    }

    @BeforeMethod
    public void setup(Method method) {
        System.setProperty("webdriver.chrome.driver","src/test/resources/browserDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

//        Test test = method.getAnnotation(Test.class);
//        System.out.println("Test Name - " +test.testName());
//        System.out.println("Test Description is - "+test.description());

        logger = extent.createTest(method.getName());

    }

    @AfterMethod
    public void getResult(ITestResult result) throws Exception{
        if(result.getStatus() == ITestResult.FAILURE){
            //MarkupHelper is used to display the output in different colors
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
            //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
            //We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method.
            //String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
            String screenshotPath = getScreenShot(driver, result.getName());
            //To add it in the extent report
            logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));

        }
        else if(result.getStatus() == ITestResult.SKIP){
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        driver.quit();
    }

    @AfterTest
    public void endReport() {
        extent.flush();
    }
}
