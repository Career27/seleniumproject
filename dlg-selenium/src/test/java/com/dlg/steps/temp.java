package com.dlg.steps;

import com.dlg.covercheck.pageFactory.CovercheckPageFactory;
import com.dlg.web.utilities.RequirementUtils;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class temp {
    public static void main(String[] args) {
        RequirementUtils req = new RequirementUtils();
        String BROWSERs = req.getEnvPropertyValue("BROWSER");
        System.out.println(BROWSERs);
//        WebDriver driver = Env.CreateWebDriver();
//        driver.get("http://www.hotukdeals.com/");
        System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");

        InternetExplorerDriver driver = new InternetExplorerDriver();

        CovercheckPageFactory pf = new CovercheckPageFactory(driver);

    }
}
