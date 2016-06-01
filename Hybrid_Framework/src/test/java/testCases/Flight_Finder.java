package testCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.FlightFinder_Page;
import utils.BrowserOperation;
import utils.ExcelUtility;
import utils.FrameworkException;
import utils.ObjectMethods;

public class Flight_Finder {
	Logger log = Logger.getLogger("selenium");

	@BeforeMethod
	
//This method will open the browser and also the website ..//
	
	public void openUrl() throws FrameworkException{

		BrowserOperation.openBrowser();

		log.info("browser succesfully open");

		BrowserOperation.openApplication();

		log.info("application succesfully open");

	}

	@Test(dataProvider="Authentication")
	
	// This method will test flight booking page..//
	
	public void flightdetails(String UserName,String Password)throws  Exception{

		log.debug("start of flight Testcase");

		ObjectMethods.inputText(FlightFinder_Page.Login_UserName_TextBox,UserName );

		ObjectMethods.inputText(FlightFinder_Page.Login_Password_TextBox, Password);

		ObjectMethods.clickElement(FlightFinder_Page.Login_Submit_Button);

		ObjectMethods.clickElement(FlightFinder_Page.Oneway_Radio_button);

		ObjectMethods.dropDownBox(FlightFinder_Page.FLIGHT_FINDER_PASSENGERS_DROPDOWNLIST, "3");

		ObjectMethods.dropDownBox(FlightFinder_Page.FLIGHT_FINDER_DEPARTING_FROM_DROPDOWNLIST, "London");

		ObjectMethods.dropDownBox(FlightFinder_Page.FLIGHT_FINDER_ON_DAY_DROPDOWNLIST, "12");

		ObjectMethods.dropDownBox(FlightFinder_Page.FLIGHT_FINDER_ON_MONTH_DROPDOWNLIST, "June");

		ObjectMethods.dropDownBox(FlightFinder_Page.FLIGHT_FINDER_ARRIVING_IN_DROPDOWNLIST, "Paris");

		ObjectMethods.dropDownBox(FlightFinder_Page.FLIGHT_FINDER_RETURNING_MONTH_DROPDOWNLIST, "July");

		ObjectMethods.dropDownBox(FlightFinder_Page.FLIGHT_FINDER_RETURNING_DAY_DROPDOWNLIST, "3");

		ObjectMethods.clickElement(FlightFinder_Page.FLIGHT_FINDER_SERVICE_CLASS_RADIO_BUTTON);

		ObjectMethods.dropDownBox(FlightFinder_Page.FLIGHT_FINDER_AIRLINE_DROPDOWNLIST,"Unified Airlines");

		ObjectMethods.clickElement(FlightFinder_Page.Flight_Finder_Continue_Button);

		ObjectMethods.clickElement(FlightFinder_Page.FLIGHT_FINDER_DEPART);

		BrowserOperation.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		ObjectMethods.clickElement(FlightFinder_Page.FLIGHT_FINDER_DEPART);

		ObjectMethods.clickElement(FlightFinder_Page.Select_Flight_Continue_Button);

		Thread.sleep(3000);

		ObjectMethods.inputText(FlightFinder_Page.FIRST_NAME,"JON");

		BrowserOperation.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		ObjectMethods.inputText(FlightFinder_Page.LAST_NAME,"SNOW");

		BrowserOperation.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		ObjectMethods.dropDownBox(FlightFinder_Page.MEAL, "Hindu");

		Thread.sleep(3000);

		ObjectMethods.inputText(FlightFinder_Page.CARD_TYPE, "Visa");

		BrowserOperation.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		ObjectMethods.inputText(FlightFinder_Page.CREDIT_CARD_NUMBER, "1234567");

		Thread.sleep(3000);

		ObjectMethods.dropDownBox(FlightFinder_Page.CREDIT_CARD_EXPIRY_MONTH, "2009");

		Thread.sleep(3000);

		ObjectMethods.dropDownBox(FlightFinder_Page.CREDIT_CARD_EXPIRY_DATE, "10");

		Thread.sleep(3000);

		ObjectMethods.inputText(FlightFinder_Page.CREDIT_CARD_FIRSTNAME, "JON");

		Thread.sleep(3000);

		ObjectMethods.inputText(FlightFinder_Page.CREDIT_CARD_LASTNAME, "SNOW");

		Thread.sleep(3000);

		ObjectMethods.inputText(FlightFinder_Page.CREDIT_CARD_MIDDLENAME, "STARK");

		Thread.sleep(3000);

		ObjectMethods.clearText(FlightFinder_Page.BILLING_ADDRESS);

		Thread.sleep(3000);

		ObjectMethods.inputText(FlightFinder_Page.BILLING_ADDRESS, "NEW DELHI LAXMI NAGAR");

		Thread.sleep(3000);

		ObjectMethods.clearText(FlightFinder_Page.BILLING_ADDRESS_CITY);

		Thread.sleep(3000);

		ObjectMethods.inputText(FlightFinder_Page.BILLING_ADDRESS_CITY, "DELHI");

		Thread.sleep(3000);

		ObjectMethods.clearText(FlightFinder_Page.BILLING_ADDRESS_STATE);

		Thread.sleep(3000);

		ObjectMethods.inputText(FlightFinder_Page.BILLING_ADDRESS_STATE, "NEW DELHI");

		Thread.sleep(3000);

		ObjectMethods.clearText(FlightFinder_Page.BILLING_ADDRESS_POSTALCODE);

		Thread.sleep(3000);

		ObjectMethods.inputText(FlightFinder_Page.BILLING_ADDRESS_POSTALCODE, "110092");

		Thread.sleep(3000);

		ObjectMethods.dropDownBox(FlightFinder_Page.BILLING_ADDRESS_COUNTRY, "INDIA");

		Thread.sleep(3000);

		ObjectMethods.clearText(FlightFinder_Page.DELIVERY_ADDRESS);

		Thread.sleep(3000);

		ObjectMethods.inputText(FlightFinder_Page.DELIVERY_ADDRESS, "NEW DELHI LAXMI NAGAR");

		Thread.sleep(3000);

		ObjectMethods.clearText(FlightFinder_Page.DELIVERY_ADDRESS_CITY);

		Thread.sleep(3000);

		ObjectMethods.inputText(FlightFinder_Page.DELIVERY_ADDRESS_CITY, "DELHI");

		Thread.sleep(3000);

		ObjectMethods.clearText(FlightFinder_Page.DELIVERY_ADDRESS_STATE);

		Thread.sleep(3000);

		ObjectMethods.inputText(FlightFinder_Page.DELIVERY_ADDRESS_STATE, "NEW DELHI");

		Thread.sleep(3000);

		ObjectMethods.clearText(FlightFinder_Page.DELIVERY_ADDRESS_POSTALCODE);

		Thread.sleep(3000);

		ObjectMethods.inputText(FlightFinder_Page.DELIVERY_ADDRESS_POSTALCODE, "110092");

		ObjectMethods.clickElement(FlightFinder_Page.SELECT_PURCHASE);

		log.debug("end of flight Testcase");
	}
	@DataProvider
	
	//This method will read "username" and "password" from excel sheet and pass to above method//
	
	public Object[][] Authentication() throws Exception{

		Object[][] testObjArray = ExcelUtility.getTableArray("src//test//java//TestData//TEST_DATA.xlsx","Sheet1");
		
		log.info("Excel sheet error");
		
		return (testObjArray);

	}
	
	@AfterMethod
	
	//This method will close all browser sessions,//
	
	public void closepage(){

		BrowserOperation.closeBrowser();

		log.info("Browser close error");
	}

}


