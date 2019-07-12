package com.dlg.web.env;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
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

		switch (browser.toLowerCase()) {
			case "ff":
			case "firefox":
				System.setProperty("webdriver.gecko.driver", "src/test/resources/browserDrivers/geckodriver.exe");
				driver = new FirefoxDriver(cap);
				break;

			case "ie" :
			case "internetexplorer":
				System.setProperty("webdriver.ie.driver", "src/test/resources/browserDrivers/IEDriverServer.exe");
				cap.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
				driver = new InternetExplorerDriver(cap);
				break;

			case "chrome" :
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("download.default_directory", "D:\\enterprise automation\\downloads");
				prefs.put("profile.default_content_setting_values.automatic_downloads", 1);
				prefs.put("download.prompt_for_download", false); //Turns off download prompt
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
//				options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
//				options.setCapability(ChromeOptions.CAPABILITY, options);

				options.addArguments("enable-automation");
//				options.addArguments("--headless");
//				options.addArguments("--window-size=1920,1080");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-extensions");
				options.addArguments("--dns-prefetch-disable");
				options.addArguments("--disable-gpu");
//				options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

				options.addArguments("--start-maximized");
//				options.addArguments("--start-fullscreen");

				System.setProperty("webdriver.chrome.driver", "src/test/resources/browserDrivers/chromedriver.exe");
				driver = new ChromeDriver(options);

				break;

			default:
				System.out.println("Invalid browser name "+browser);
				System.exit(0);
				break;
		}

//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		return driver;
	}
}
