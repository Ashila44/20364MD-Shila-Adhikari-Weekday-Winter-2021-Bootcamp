package TestCases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import PageObjects.FlightBookingPO;
import utilityExpedia.CommonUtilityExpedia;

public class FlightBookingTestCase extends CommonUtilityExpedia {
  @Test
  public void flightBookingTC() throws InterruptedException
  {
	  FlightBookingPO objBooking = new FlightBookingPO(driver);
	  Thread.sleep(30000); //This is 30 seconds wait time just in case the page throws Bot Captcha screen to manually intervene...
	  objBooking.clickFlightsLink();
	  Thread.sleep(3000);
	  objBooking.enterOrigin("IAD");
	  Thread.sleep(6000);
	  objBooking.enterDestination("RDU");
	  Thread.sleep(3000);
	  objBooking.clickSearchButton();
	  Thread.sleep(15000);
	  objBooking.clickSortList();
	  Thread.sleep(3000);
	  objBooking.clickFirstFlight();
	  Thread.sleep(3000);
	  objBooking.clickFirstFlightSelection();
	  Thread.sleep(3000);
	  objBooking.clickSortList();
	  objBooking.clickSecondFlight();
	  Thread.sleep(3000);
	  objBooking.clickSecondFlightSelection();
	  Thread.sleep(6000);
	  objBooking.clicknoThanksLink();
	  
	  //After selecting round trip flight, checkout page opens in new Tab. Thus we need to use window handle to 
	  //select right window to perform rest of the actions related to checkout.....
	  
	  	Set<String> expediaWinHandles = driver.getWindowHandles(); //This will store all windowHandles.....
	    Iterator<String> WinIterator = expediaWinHandles.iterator(); //Iterator is used to find all window handles...
	    
	    String originalWindow = WinIterator.next(); //This will store first (OR Parent) window/tab Handle in variable "firstWinhandle"...
	    System.out.println("First: "+originalWindow);
	    String newTab = WinIterator.next(); //This will store second (OR child) window/tab Handle in variable "secondWinHandle:...
	    System.out.println("Second : " + newTab);
	    
	    //Switching to the child (OR second) window to perform actions on the second WINDOW or TAB....
	    driver.switchTo().window(newTab); 
	    
	    Thread.sleep(6000);
	    objBooking.clickCheckOutButton();
	    
	    objBooking.enterFirstName("Shila");
	    objBooking.enterLastName("Sharma");
	    objBooking.enterPhoneNum("1234567890");
	    Thread.sleep(3000);
	    objBooking.clickGender("Female");
	    objBooking.selectMonth("April");
	    Thread.sleep(3000);
	    objBooking.selectDay("12");
	    Thread.sleep(3000);
	    objBooking.selectYear("2001");
	    Thread.sleep(3000);
	    objBooking.clickInsuranceOption("no");
	    Thread.sleep(6000);
	    objBooking.enterCardNumber("4000056655665556");
	    objBooking.selectExpMonth("6");
	    Thread.sleep(3000);
	    objBooking.selectExpYear("2023");
	    objBooking.enterSecurityCode("456");
	    Thread.sleep(3000);
	    objBooking.enterBillingAddress("8133 Leesburg Pike");
	    objBooking.enterBillingCity("Vienna");
	    objBooking.selectBillingState("VA");
	    objBooking.enterBillingZipCode("22182");
	    Thread.sleep(3000);
	    //Need to scroll down to find element to enter email...
	    
	    JavascriptExecutor objJscriptExcutr = (JavascriptExecutor) driver;
	    objJscriptExcutr.executeScript("window.scrollBy(0,300)");
	    objBooking.enterAccountEmail("shila20364MD.bootcamp@gmail.com");
	    objBooking.enterAccountPassword("Pass3456");
	    Thread.sleep(3000);
	    objJscriptExcutr.executeScript("window.scrollBy(0,600)");
	    Thread.sleep(3000);
	    objBooking.clickCompleteBooking();
	    
	    
	    
	    
	    
	  
  }
}
