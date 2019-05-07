package com.dlg.web.env;


import com.dlg.web.utilities.RequirementUtils;
import com.dlg.web.utilities.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public interface BaseTest
{
	RequirementUtils requtil = new RequirementUtils();
	String BROWSER_NAME = requtil.getEnvPropertyValue("BROWSER_NAME");

	public static WebDriver driver = Env.CreateWebDriver(BROWSER_NAME);
	public static WebDriverWait wait = new WebDriverWait(driver, 30);


}
