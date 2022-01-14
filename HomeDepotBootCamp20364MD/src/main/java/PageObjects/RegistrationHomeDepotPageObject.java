package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationHomeDepotPageObject 
{
	//Creating Pagefactory and initiating driver ......
	public WebDriver driver;
	public RegistrationHomeDepotPageObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//identifying WebElements and methods to perform actions on each Web-Elements starting from Home Depot Homepage....
	
	@FindBy(linkText = "My Account") WebElement myAccountLink;
	public void clickMyAccountLink()
	{
		myAccountLink.click();
	}
	
	@FindBy(xpath = "//span[contains(text(),'Register')]") WebElement registrationButton;
	public void clickRegistrationButton()
	{
		registrationButton.click();
	}
	
	@FindBy(xpath = "//p[contains(text(),\"I'm shopping for myself\")]") WebElement personalAClink;
	public void clickPersonalACLink()
	{
		personalAClink.click();
	}
	
	@FindBy(id = "email") WebElement emailInputBox;
	public void enterEmail(String email)
	{
		emailInputBox.sendKeys(email);
	}
	
	@FindBy(id = "password-input-field") WebElement passwordInputBox;
	public void enterPassword(String password)
	{
		passwordInputBox.sendKeys(password);
	}
	
	@FindBy(id = "zipCode") WebElement zipcodeInputBox;
	public void enterZipCode(String zipCode)
	{
		zipcodeInputBox.sendKeys(zipCode);
	}
	
	@FindBy(id = "phone") WebElement phoneInputBox;
	public void enterPhoneNumber(String phoneNumber)
	{
		phoneInputBox.sendKeys(phoneNumber);
	}

	@FindBy(xpath = "//div[contains(text(),'Please verify that you are not a robot.')]") WebElement verifyRobotMsg;
	public String captureVerifyRobotMessage()
	{
		String robotMessage = verifyRobotMsg.getText();
		return robotMessage;	
	}
	
	@FindBy(xpath = "//span[contains(text(),'Create an Account')]") WebElement createACButton;
	public void clickCreateACButton()
	{
		createACButton.click();
	}
	
	
	
}
