package com.w2a.cucumber.parallel.google;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseSteps {

	protected WebDriver driver;
	public static ThreadLocal<WebDriver> dr = new  ThreadLocal<WebDriver>();
	// init
	public static WebDriver getDriver(){
		return dr.get();
	}
	
	public static void setWebDriver(WebDriver driver){
		dr.set(driver);
	}

	protected void startWebDriver(String browser) {
		if (browser.equals("firefox")) {
			driver = new FirefoxDriver();

		} else if (browser.equals("chrome")) {
			driver = new ChromeDriver();

		}
		setWebDriver(driver);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	protected void navigate(String url) throws InterruptedException {
		Thread.sleep(2000);
		getDriver().navigate().to(url);
	}


	protected void stopWebDriver(){
		getDriver().quit();
	}
}
