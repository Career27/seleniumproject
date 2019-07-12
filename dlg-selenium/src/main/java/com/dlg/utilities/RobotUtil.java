package com.dlg.utilities;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotUtil {
    public static void saveFile() throws InterruptedException {

        try {
            Robot robot = new Robot();
            //get the focus on the element..don't use click since it stalls the driver
            //simulate pressing enter
            robot.keyPress(KeyEvent.VK_ALT);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_S);
            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_S);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_ESCAPE);
            robot.keyRelease(KeyEvent.VK_ESCAPE);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

}