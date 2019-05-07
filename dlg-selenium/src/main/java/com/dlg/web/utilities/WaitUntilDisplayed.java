package com.dlg.web.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WaitUntilDisplayed {
	WebDriver driver;
	
	public boolean waitUntilElementIsDisplayed(By by,int Seconds){
		
		if (checkElementExists(by,Seconds)){
			for (int i=0; i<Seconds; i++){
				if (driver.findElement(by).isDisplayed())
					return false;
				else
					sleep(1000);
			}
				return false;
		}
		else{
		return false;
		}
		
	}

	private void sleep(int i){
		// TODO Auto-generated method stub
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private boolean checkElementExists(By by, int seconds) {
		// TODO Auto-generated method stubi
		boolean result=false;
		try{
			driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
			driver.findElement(by);
			result=true;
			
		}catch (org.openqa.selenium.NoSuchElementException ex){
			result=false;
		}
		finally{
//			DriverUtil.settingImplicitWait();
			
		}
		
		return false;
	}

}



