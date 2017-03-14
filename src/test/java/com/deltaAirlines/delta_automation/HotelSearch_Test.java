package com.deltaAirlines.delta_automation;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.HotelSearch_POF;

public class HotelSearch_Test extends Main_Test {
	@Test(enabled = true)
	@Parameters({ "daysFromCurrentDate", "inputLocation", "locationInDropdown" })
	public void verifyHotelSearch(int daysFromCurrentDate, String inputLocation, String locationInDropdown)
			throws InterruptedException {
		HotelSearch_POF hotelSearch_POF = PageFactory.initElements(driver, HotelSearch_POF.class);
		// Getting drop down under shop upper tab
		hotelSearch_POF.mouseOverOnShopTab(driver);
		// Clicking Hotels option
		hotelSearch_POF.clickHotelsOption(driver);
		// Enter hotel location
		hotelSearch_POF.enterHotelLocation(driver, inputLocation);
		hotelSearch_POF.createHotelLocationsList(driver, locationInDropdown);
		// Enter check in and out dates
		hotelSearch_POF.enterCheckInOutDate(driver, daysFromCurrentDate);
		// Selecting number of rooms
		hotelSearch_POF.clickHotelNumberOfRooms(driver);
		hotelSearch_POF.clickRandomElementFromList(driver);
		// Selecting number of adults
		hotelSearch_POF.selectNumberOFAdults(driver);
		// Clicking find hotels button
		hotelSearch_POF.clickFindHotelsButton(driver);
		// Asserting of user was navigated to the expected page
		hotelSearch_POF.waitForHotelSearchResultsTitle(driver);
		// Double verify - if the number of hotels foud is greater than 0
		int totalNumHotels = hotelSearch_POF.getStringParseToInt(driver);
		Assert.assertTrue(totalNumHotels > 0);
	}
}
