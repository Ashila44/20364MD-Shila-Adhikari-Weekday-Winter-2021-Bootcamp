package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.RegistrationHomeDepotPageObject;
import UtilityHomeDepot.CommonUtilityHomeDepot;

public class RegistrationHomeDepotTC extends CommonUtilityHomeDepot {
	
	/*This test case will verify invalid account registration attempt by providing valid details, but NOT checking the 
	 * Robot Captcha check box......
	 * The error message will be captured during run time and will be compared using Assertion to validate test result. 
	 */
	
  @Test
  public void homeDepotRegistration() throws InterruptedException, IOException 
  {
	  RegistrationHomeDepotPageObject objRegPO = new RegistrationHomeDepotPageObject(driver);
	  objRegPO.clickMyAccountLink();
	  Thread.sleep(3000);
	  objRegPO.clickRegistrationButton();
	  Thread.sleep(3000);
	  objRegPO.clickPersonalACLink();
	  Thread.sleep(3000);
	  objRegPO.enterEmail("abcdef567567@gmail.com");
	  objRegPO.enterPassword("PPaasWD$56$67");
	  objRegPO.enterZipCode("21212");
	  objRegPO.enterPhoneNumber("4438855159");
	  Thread.sleep(3000);
	  objRegPO.clickCreateACButton();
	  Thread.sleep(6000);
	  screenShots();
	  String RobotErrMessage = objRegPO.captureVerifyRobotMessage();
	  System.out.println(RobotErrMessage);
	  
	  //Add assertions......and validate failure....
	  
	  
	  
	  
	  
	  
	  
	  
  }
}
