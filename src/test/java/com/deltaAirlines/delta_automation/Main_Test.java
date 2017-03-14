package com.deltaAirlines.delta_automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class Main_Test {
	static WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeTest
	public static WebDriver getWebDriver(String browser, String url) {

		// Launch the FireFox browser
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"/Users/dan/Dropbox/Portfolio_workspace/delta-automation/webDrivers/chromedriver");
			driver = new ChromeDriver();
		}
		// Navigate to AUT, managing the browser window
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);

		return driver;
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		// Clean up environment
		driver.quit();
	}
}