package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightBookingPO 
{
	//Creating Pagefactory and initiating driver ......
	public WebDriver driver;
	public FlightBookingPO(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//identifying WebElements and methods to perform actions on each Web-Elements starting from Home Depot Homepage....
	
		@FindBy(xpath = "//body/div[@id='app-blossom-flex-ui']/div[@id='app-layer-manager']/div[@id='app-layer-base']/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]") WebElement flightsLink;
		public void clickFlightsLink()
		{
			flightsLink.click();
		}
		
		@FindBy(xpath = "//body/div[@id='app-blossom-flex-ui']/div[@id='app-layer-manager']"
				+ "/div[@id='app-layer-base']/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]"
				+ "/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/"
				+ "div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1"
				+ "]/div[1]/div[1]/div[1]/div[1]/button[1]") WebElement leavingFromBox;
		
		public void enterOrigin(String originAirport) throws InterruptedException
		{
			//leavingFromBox.sendKeys((originAirport), Keys.TAB,Keys.TAB, Keys.ENTER);
			leavingFromBox.click();
			Actions ob =new Actions(driver);
			ob.sendKeys(originAirport).build().perform();
			Thread.sleep(3000);
			ob.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
			
		}
		
		@FindBy(xpath = "//body/div[@id='app-blossom-flex-ui']/div[@id='app-layer-manager']/div"
				+ "[@id='app-layer-base']/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div"
				+ "[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div"
				+ "[1]/form[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]"
				+ "/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]") WebElement goingToBox;
		
		public void enterDestination(String destinationAirport) throws InterruptedException
		{
			//leavingFromBox.sendKeys((originAirport), Keys.TAB,Keys.TAB, Keys.ENTER);
			goingToBox.click();
			Actions ob =new Actions(driver);
			ob.sendKeys(destinationAirport).build().perform();
			Thread.sleep(3000);
			ob.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();	
		}
	
		@FindBy(xpath="//button[contains(text(),'Search')]") WebElement searchButton;
		public void clickSearchButton()
		{
			searchButton.click();
		}
		
		@FindBy(id="listings-sort") WebElement listSorting;
		public void clickSortList() throws InterruptedException
		{
			listSorting.click();
			Thread.sleep(1000);
			listSorting.click();
		} 
		

		public void clickFirstFlight()
		{
			Actions ob =new Actions(driver);
			ob.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
		}
		
		@FindBy(xpath="//body/div[@id='app-flights-shopping-pwa']/div[@id='app-layer-manager']/div[@id='app-layer-base']/div[2]/div[3]/div[1]/section[1]/main[1]/div[6]/section[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[1]/div[1]/button[1]") WebElement selectFirstFlight;
		public void clickFirstFlightSelection()
		{
			selectFirstFlight.click();
		}
		

		public void clickSecondFlight()
		{
			Actions ob =new Actions(driver);
			ob.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
		}	
		
		@FindBy(xpath="//button[contains(text(),'Select')]") WebElement selectSecondFlight;
		public void clickSecondFlightSelection()
		{
			selectSecondFlight.click();
		}
		
		@FindBy(linkText="No thanks") WebElement noThanksLink;
		public void clicknoThanksLink()
		{
			noThanksLink.click();
		}
		
		@FindBy(xpath="//button[@aria-label='Continue to checkout']") WebElement checkoutButton;
		public void clickCheckOutButton()
		{
			checkoutButton.click();
		}
		
		//Locating webElements to fill passenger's information and creating action methods.....
		
		//First Name Field
		@FindBy(id="firstname[0]") WebElement firstNameField;
		public void enterFirstName(String fName)
		{
			firstNameField.sendKeys(fName);
		} 
		
		//Last Name Field
		@FindBy(id="lastname[0]") WebElement lastNameField;
		public void enterLastName(String lName)
		{
			lastNameField.sendKeys(lName);
		}         
		
				//Phone Number Field
				@FindBy(id="phone-number[0]") WebElement phoneField;
				public void enterPhoneNum(String phoneNum)
				{
					phoneField.sendKeys(phoneNum);
				} 
				
				
						//Male OR Female radio Button.....
				@FindBy(id="gender_male[0]") WebElement maleRadio;
				@FindBy(id="gender_female[0]") WebElement femaleRadio;
						public void clickGender(String gender)
						{
							if(gender.equalsIgnoreCase("MALE"))
							{
								
								maleRadio.click();
							}
							else if(gender.equalsIgnoreCase("FEMALE"))
							{
								
								femaleRadio.click();
							}
							
								
						} 
						
						//identify month selection element
						@FindBy(id="date_of_birth_month0") WebElement monthSelection;
						public void selectMonth(String month)
						{
							Select objMonth = new Select(monthSelection);
							
							  if(month.equalsIgnoreCase("January")) {
								objMonth.selectByValue("01");
							} else if(month.equalsIgnoreCase("February"))
							{
								objMonth.selectByValue("02");
							} else if(month.equalsIgnoreCase("March"))
							{
								objMonth.selectByValue("03");
							} else if(month.equalsIgnoreCase("April"))
							{
								objMonth.selectByValue("04");
							}else if(month.equalsIgnoreCase("May"))
							{
								objMonth.selectByValue("05");
							}else if(month.equalsIgnoreCase("June"))
							{
								objMonth.selectByValue("06");
							}else if(month.equalsIgnoreCase("July"))
							{
								objMonth.selectByValue("07");
							}else if(month.equalsIgnoreCase("August"))
							{
								objMonth.selectByValue("08");
							}else if(month.equalsIgnoreCase("September"))
							{
								objMonth.selectByValue("09");
							}else if(month.equalsIgnoreCase("October"))
							{
								objMonth.selectByValue("10");
							}else if(month.equalsIgnoreCase("November"))
							{
								objMonth.selectByValue("11");
							}else if(month.equalsIgnoreCase("December"))
							{
								objMonth.selectByValue("12");
							} else
							{
								System.out.println("Invalid Month Name: Please Correct it.....");
							}
			
						}
						
						//Identify Day Selection WebElement....
						@FindBy(id="date_of_birth_day[0]") WebElement daySelection;
						public void selectDay(String day)
						{
							Select objDay = new Select(daySelection);
							objDay.selectByValue(day);
							
						}
						
						//Identify year Selection WebElement
						@FindBy(id="date_of_birth_year[0]") WebElement yearSelection;
						public void selectYear(String year)
						{
							Select objYear = new Select(yearSelection);
							objYear.selectByValue(year);
							
						}
						
						//Selecting no insurance radio button
						@FindBy(id="no_insurance") WebElement insuranceNORadioButton;
						@FindBy(id="yes_insurance") WebElement insuranceYESRadioButton;
						public void clickInsuranceOption(String option)
						{
							if(option.equalsIgnoreCase("YES"))
							{
								insuranceYESRadioButton.click();
								
							} 
							else if (option.equalsIgnoreCase("NO"))
							{
								insuranceNORadioButton.click();
							}
						}
						
						
						//Identify webelement to enter debit/credit card details...
						@FindBy(id="creditCardInput") WebElement cardField;
						public void enterCardNumber(String cardNumber)
						{
							cardField.sendKeys(cardNumber);
						}
						
						//Identify webelement to select expiration month.....
						@FindBy(name="creditCards[0].expiration_month") WebElement selectExpirationMonth;
						public void selectExpMonth(String monthDigit)
						{
							Select objExpMonth = new Select (selectExpirationMonth);
							objExpMonth.selectByValue(monthDigit);
						}
						
						//Identify webelement to select expiration year.....
						@FindBy(name="creditCards[0].expiration_year") WebElement selectExpirationYear;
						public void selectExpYear(String year)
						{
							Select objExpYear = new Select (selectExpirationYear);
							objExpYear.selectByValue(year);
						}
						
						//Identify webelement to enter 3 digit security code of debit/credit....
						@FindBy(id="new_cc_security_code") WebElement securityCodeBox;
						public void enterSecurityCode(String code)
						{
							securityCodeBox.sendKeys(code);
						}
						
						//Identification and Methods for entering address details.....
						
						
						//Billing address 
						@FindBy(name="creditCards[0].street") WebElement billingAddressBox;
						public void enterBillingAddress(String address)
						{
							billingAddressBox.sendKeys(address);
						}
						
						//Billing City 
						@FindBy(name="creditCards[0].city") WebElement billingCityBox;
						public void enterBillingCity(String city)
						{
							billingCityBox.sendKeys(city);
						}
						
						//Billing State
						@FindBy(xpath="//body/div[@id='site-content']/div[1]/div[13]/section[2]/article[4]/fieldset[1]/div[1]/div[2]/div[2]"
								+ "/div[2]/form[1]/fieldset[1]/div[1]/div[1]/div[3]/div[1]/fieldset[1]/div[3]/label[4]/select[1]") WebElement billingStateSelection;
						public void selectBillingState(String State)
						{
							Select objBillingState = new Select(billingStateSelection);
							objBillingState.selectByValue(State);
						}    
						
						//Billing City 
						@FindBy(name="creditCards[0].zipcode") WebElement billingZipCodeBox;
						public void enterBillingZipCode(String zipcode)
						{
							billingZipCodeBox.sendKeys(zipcode);
						}
						
						//Customer Account creation......
						//Account Email 
						@FindBy(xpath="//body/div[@id='site-content']/div[1]/div[13]/section[2]/article[5]/div[1]/fieldset[1]/div[1]/div[2]/fieldset[1]/label[1]/input[1]") WebElement accountEmailBox;
						public void enterAccountEmail(String email)
						{
							accountEmailBox.sendKeys(email);
						}   
						
						//Account Password creation
						@FindBy(xpath="//body/div[@id='site-content']/div[1]/div[13]/section[2]/article[5]/div[1]/fieldset[1]/div[2]/fieldset[1]/label[1]/input[1]") WebElement accountPasswordBox;
						
						public void enterAccountPassword(String password) 
						{
							Actions ob =new Actions(driver);
							accountPasswordBox.sendKeys(password);	
							ob.sendKeys(Keys.TAB).sendKeys(password).build().perform();
						}
						

						
						//Click Complete Booking
						@FindBy(id="complete-booking") WebElement completeBookingButton;
						public void clickCompleteBooking()
						{
							completeBookingButton.click();
						}

}
