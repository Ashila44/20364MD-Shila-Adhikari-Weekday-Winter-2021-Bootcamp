package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchANDaddTOcartPageObject 
{
	//Creating Pagefactory and initializing driver ......
	public WebDriver driver;
	public SearchANDaddTOcartPageObject(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Below, identifying all the required WebElements and Creating methods to be used in Test Case....
	

	@FindBy(id="twotabsearchtextbox") WebElement searchBox;	//(1) Search Box
	public void enterSearchBox(String item) //method used in search box....
	{
		searchBox.sendKeys(item);
	}
	
	@FindBy(id="nav-search-submit-button") WebElement searchButton; //(2) Search button
	public void clickSearchButton() //method used to click search button...
	{
		searchButton.click();
	}
	
	
	@FindBy(xpath="//span[contains(text(),'Rove R2-4K Dash Cam Built in WiFi GPS Car Dashboar')]") WebElement desiredItem;
	public void clickDesiredItem()
	{		
		desiredItem.click();
	}
	
	@FindBy(id="add-to-cart-button") WebElement addToCartButton;
	public void clickAddToCart()
	{
		addToCartButton.click();
	}
}
