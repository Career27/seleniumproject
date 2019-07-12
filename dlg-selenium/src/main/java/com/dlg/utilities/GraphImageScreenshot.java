package com.dlg.utilities;

import com.dlg.web.env.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphImageScreenshot implements BaseTest {

    public static void graphScreenshot(WebElement graphType){

        try {
// Get entire page screenshot
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            BufferedImage fullImg = ImageIO.read(screenshot);

// Get the location of element on the page
            Point point = graphType.getLocation();

// Get width and height of the element
            int eleWidth = graphType.getSize().getWidth();
            int eleHeight = graphType.getSize().getHeight();

// Crop the entire page screenshot to get only element screenshot
            BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
                    eleWidth, eleHeight);
            ImageIO.write(eleScreenshot, "png", screenshot);

// Copy the element screenshot to disk
            File screenshotLocation = new File("C:\\images\\screenshot.png");
            FileUtils.copyFile(screenshot, screenshotLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
