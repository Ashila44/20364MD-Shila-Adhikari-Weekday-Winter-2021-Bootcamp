package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import PageObjects.SearchANDaddTOcartPageObject;
import UtilityAmazon.CommonUtilityAmazon;

public class SearchAndAddToCartTestCase extends CommonUtilityAmazon {
  @Test
  public void searchANDaddTOcart() throws InterruptedException, IOException 
  {
	  SearchANDaddTOcartPageObject myObj = new SearchANDaddTOcartPageObject(driver);
	  //Now performing actions to search and add an item to cart....
	  myObj.enterSearchBox("Rove 4k dash cam");
	  screenShots();
	  myObj.clickSearchButton();
	  Thread.sleep(6000);
	  screenShots();
	  myObj.clickDesiredItem();
	  Thread.sleep(3000);
	  screenShots();
	  myObj.clickAddToCart();
	  Thread.sleep(3000);
	  screenShots();
  }
}
