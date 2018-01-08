package com.logituit;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy.ByAccessibilityId;
import io.appium.java_client.android.AndroidDriver;

public class GuardHat {
	
	public static AndroidDriver driver;
	
	@BeforeTest
	public void Setup () throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Motorola E4 Plus");
		capabilities.setCapability("platformVersion", "7.1.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.guardhat.kyra.mobile");
		capabilities.setCapability("appActivity", "com.guardhat.kyra.mobile.Views.Activities.KyraActivity");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	
	@Test (priority = 1)
	public void Login () throws MalformedURLException {
		
		// Permissions
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		
		// Setting
		driver.findElement(By.id("com.guardhat.kyra.mobile:id/reset")).click();
		driver.findElement(By.id("com.guardhat.kyra.mobile:id/urlText")).clear();
		driver.findElement(By.id("com.guardhat.kyra.mobile:id/urlText")).sendKeys("cloud-qa.guardhat.net");
		driver.findElement(By.id("com.guardhat.kyra.mobile:id/ftpurlText")).clear();
		driver.findElement(By.id("com.guardhat.kyra.mobile:id/ftpurlText")).sendKeys("cloud-qa.guardhat.net");
		driver.navigate().back();
		driver.findElement(By.id("com.guardhat.kyra.mobile:id/save")).click();
		
		//Login
		driver.findElement(By.id("com.guardhat.kyra.mobile:id/username")).sendKeys("sccuser43");
		driver.findElement(By.id("com.guardhat.kyra.mobile:id/password")).sendKeys("guardhat2016");
		driver.navigate().back();
		driver.findElement(By.id("com.guardhat.kyra.mobile:id/login")).click();
		new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Logituit Site']")));
	}
	
	@Test (priority = 2)
	public void Home () throws MalformedURLException, InterruptedException {
	//	 Boolean iselementpresent = driver.findElementsByXPath("//*[@content-desc='6b44b600-19b8-44b4-918c-7cac7d5760e8. ']").size() != 0;
	//	Assert.assertTrue(iselementpresent,"Targeted element App is present on screen");
		 driver.findElement(By.id("com.guardhat.kyra.mobile:id/sos")).click();
		 Thread.sleep(18000);
	}
	
	@Test (priority = 3)
	public void Events () throws MalformedURLException{
		 driver.findElementByAccessibilityId("Open navigation drawer").click();
		 driver.findElement(By.xpath("//*[@text='Event List']")).click();
		 new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='totalNonCritical']")));
		 driver.findElement(By.xpath("//*[@text='Hat Powered On']")).click();
		 driver.findElement(By.xpath("//*[@id='maximise']")).click();
		 driver.findElement(By.xpath("//*[@id='my_location']")).click();
		 driver.findElement(By.xpath("//*[@id='back']")).click();
		 driver.findElement(By.xpath("//*[@id='back']")).click();
		 new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='totalNonCritical']")));




	}
	
	@Test (priority = 4)
	public void WorkersList () throws MalformedURLException{
		 driver.findElementByAccessibilityId("Open navigation drawer").click();
		 driver.findElement(By.xpath("//*[@text='Worker List']")).click();
		 new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='ONLINE']")));
		 driver.findElement(By.xpath("//*[@text='GH1043']")).click();
		 driver.findElement(By.xpath("//*[@id='maximise']")).click();
		 driver.findElement(By.xpath("//*[@id='my_location']")).click();
		 driver.findElement(By.xpath("//*[@id='back']")).click();
		 driver.findElement(By.xpath("//*[@id='back']")).click();
		 new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='ONLINE']")));
	}
	
	@Test (priority = 5)
	public void Geofence () throws MalformedURLException{
		 driver.findElementByAccessibilityId("Open navigation drawer").click();
		 driver.findElement(By.xpath("//*[@text='Geofences']")).click();

	}
	
	@Test (priority = 6)
	public void Media () throws MalformedURLException{
		 driver.findElementByAccessibilityId("Open navigation drawer").click();
		 driver.findElement(By.xpath("//*[@text='Media']")).click();

	}
	
	@Test (priority = 7)
	public void Setting () throws MalformedURLException{
		 driver.findElementByAccessibilityId("Open navigation drawer").click();
		 driver.findElement(By.xpath("//*[@text='Settings']")).click();
		 driver.findElement(By.xpath("//*[@text='System Configuration Manager']")).click();
		  driver.findElement(By.xpath("//*[@id='languagePopup']")).click();
		  driver.findElement(By.xpath("//*[@text='French']")).click();
		  driver.findElement(By.xpath("//*[@id='save']")).click();
		  driver.findElement(By.xpath("//*[@id='btn_yes']")).click();
		  new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='username']")));
			driver.findElement(By.id("com.guardhat.kyra.mobile:id/username")).sendKeys("sccuser43");
			driver.findElement(By.id("com.guardhat.kyra.mobile:id/password")).sendKeys("guardhat2016");
			driver.navigate().back();
			driver.findElement(By.id("com.guardhat.kyra.mobile:id/login")).click();
			new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Accueil']")));
			new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Logituit Site']")));



	}	

}
