package com.dlg.web.test;

import com.dlg.utilities.GraphImageScreenshot;
import com.dlg.utilities.HighlightElement;
import com.dlg.web.env.BaseTest;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class enterpriseElementScreenshot implements BaseTest {


    @Test
    public void test01() throws InterruptedException {

        String WEB_URL = requtil.getEnvPropertyValue("WEB_URL");
        driver.get(WEB_URL);


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

        Thread.sleep(10000);
//        WebElement element = driver.findElement(By.xpath("//div[@id='pagePane0_divBlock0Container'])"));
        WebElement graphStyleSkyline = driver.findElement(By.xpath("//*[@id='pagePane0_divBlock0']"));

        GraphImageScreenshot.graphScreenshot(graphStyleSkyline);
//        try {
//// Get entire page screenshot
//            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//            BufferedImage fullImg = ImageIO.read(screenshot);
//
//// Get the location of element on the page
//            Point point = graphStyleSkyline.getLocation();
//
//// Get width and height of the element
//            int eleWidth = graphStyleSkyline.getSize().getWidth();
//            int eleHeight = graphStyleSkyline.getSize().getHeight();
//
//// Crop the entire page screenshot to get only element screenshot
//            BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
//                    eleWidth, eleHeight);
//            ImageIO.write(eleScreenshot, "png", screenshot);
//
//// Copy the element screenshot to disk
//            File screenshotLocation = new File("C:\\images\\screenshot.png");
//            FileUtils.copyFile(screenshot, screenshotLocation);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        driver.close();

    }
}
