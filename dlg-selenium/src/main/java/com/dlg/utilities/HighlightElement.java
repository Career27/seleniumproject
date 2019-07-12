package com.dlg.utilities;

import com.dlg.web.env.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.grid.common.SeleniumProtocol.WebDriver;

public class HighlightElement implements BaseTest {

        public static void highLight(WebElement element)
        {
            for (int i = 0; i <2; i++)
            {
                try {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: black; border: 4px solid red;");
                    Thread.sleep(500);
                    js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
}