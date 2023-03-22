package com.utility;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Baseclass {
	
	public AndroidDriver d;
	@Test
	@BeforeClass
	public void brow() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy M32");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.android.settings");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.settings.homepage.SettingsHomepageActivity");
		new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
       
	}
	public void longpress(WebElement ele) {
		// WebElement ele= d.findElement(By.id(""));
		d.executeScript("mobile: longClickGesture",ImmutableMap.of("element Id",((RemoteWebElement)ele).getId(),"duration",2000));
	}
	@AfterClass
	public void teardown() {
		d.close();
	}

}
