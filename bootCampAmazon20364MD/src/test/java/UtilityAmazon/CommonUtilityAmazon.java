package UtilityAmazon;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;

public class CommonUtilityAmazon {
	public WebDriver driver;

	  @Parameters ({"Browser","URL"})
	  @BeforeMethod
	  public void beforeMethod(String Browser, String URL) throws InterruptedException 
	  { //start
		  String projectPath = System.getProperty("user.dir");
		  
		 if (Browser.equalsIgnoreCase("Chrome")) 
		 {
			System.setProperty("webdriver.chrome.driver",  projectPath +"\\src\\Drivers\\chromedriver.exe"); 
			driver = new ChromeDriver();
			driver.navigate().to(URL);
			driver.manage().window().maximize();
			Thread.sleep(3000);
			driver.navigate().refresh();
		 
		 
		 }
		 else if(Browser.equalsIgnoreCase("Edge"))
		 {
			 System.setProperty("webdriver.edge.driver", projectPath+"\\src\\Drivers\\msedgedriver.exe");
		     driver= new EdgeDriver();
		     driver.navigate().to(URL);
		     driver.manage().window().maximize();
			Thread.sleep(3000);
			driver.navigate().refresh();
		 }
		 else 
		 {
			 System.out.println("Please provide Correct browser");
		 }	   
		
	  } 

	 
	  @AfterMethod
	  public void afterMethod()
	  {
		 driver.quit();
	  }

	  public void screenShots() throws IOException
	  {
		  String projectPath = System.getProperty("user.dir");
		  
		  Date objDate = new Date();
		  System.out.println("The Java date format is: " + objDate);
		  
		  String sysDate = objDate.toString().replace(":", "_").replace(" ", "_");
		  System.out.println("Converted date is: " + sysDate);
		  
		  File stored =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileHandler.copy(stored, new File(projectPath + "\\src\\ScreenShots\\" + sysDate+"_ScreenShot.jpg"));
		  
		  
	  }
	  

}
