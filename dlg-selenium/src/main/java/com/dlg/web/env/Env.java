package com.dlg.web.env;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;



public class Env 
{
	static WebDriver driver = null;
	static String browserName = null;
	static String IE = null;
	static String cloudPlatformConfigFile = null;
	static String currentPath = System.getProperty("user.dir");
	static Properties prop = new Properties();


	public static WebDriver CreateWebDriver(String browser)
	{
//		String browser = "ie";

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("requireWindowFocus", true);
		cap.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);

		switch (browser.toLowerCase()) {
			case "ff":
			case "firefox":
				System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
				driver = new FirefoxDriver(cap);
				break;

			case "ie" :
			case "internetexplorer":
				System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
				driver = new InternetExplorerDriver(cap);
				break;

			default:
				System.out.println("Invalid browser name "+browser);
				System.exit(0);
				break;
		}

		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return driver;
	}
}
