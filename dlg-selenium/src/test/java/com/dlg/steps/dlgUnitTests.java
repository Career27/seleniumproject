package com.dlg.steps;

import com.dlg.covercheck.pageFactory.CovercheckPageFactory;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class dlgUnitTests {
    String baseURL = "https://covercheck.vwfsinsuranceportal.co.uk/";
    WebDriver driver;

    CovercheckPageFactory search = new CovercheckPageFactory(driver);

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.ie.driver", "C:\\Selenium_Java\\Softwares\\Drivers\\IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        driver.get(baseURL);

    }


    @Test
    public void test() throws Exception {

          // Click Flights tab on Home page

    }

    @After
    public void tearDown() throws Exception {
    }


}
