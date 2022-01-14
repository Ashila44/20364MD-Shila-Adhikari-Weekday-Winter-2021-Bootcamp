package apiTestCases;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import junit.framework.Assert;
import static io.restassured.RestAssured.*;

import java.io.File;

public class RestAssuredAPITest20364MD {

	public static void main(String[] args) 
	{
		/*The below is solution to Part 5: Projects:
		 * (C):Create a script with REST ASSURED which validates the response from the server for the following APIs:
		 * 	part (i)
		 * Method to use: GET					   
		 */
		Response apiResponse = get("https://reqres.in/api/users?page=2");
		apiResponse.prettyPrint();
		int responseStatus = apiResponse.getStatusCode();
		System.out.println("The response code is: "+responseStatus);
		ResponseBody apiBody = apiResponse.getBody();
		String jsonTOstring = apiBody.asString();
		
		//Using assertions to validate data in the response body....
		if(jsonTOstring.contains("Lawson"))
		{
			System.out.println("Response body contains \"Lawson\"");
		}else {
			System.out.println("Response body does not contain \"Lawson\"");
		}
		
		Assert.assertEquals(jsonTOstring.contains("Lawson"), true);
		System.out.println("response Body validation PASSED");
		
		
		
		/*The below is solution to Part 5: Projects:
		 * (C):Create a script with REST ASSURED which validates the response from the server for the following APIs:
		 * 	part (ii)
		 * Method to use: POST		https://reqres.in/api/users			   
		 */
		//Now in order to perform POST method, we need to create a json file and store the POST data in it....
		
		File apiFile = new File ("C:\\Users\\eRisheXpress\\Documents\\PnT Files\\Selenium\\PracticeFiles\\apiTestCases\\src\\test\\java\\apiPOSTdata.json");
		Response apiPost = given().contentType(ContentType.JSON).body(apiFile).post("https://reqres.in/api/users");
		apiPost.prettyPrint();
		
		int postStatusCode = apiPost.getStatusCode();
		System.out.println("The status code for POST api is: "+postStatusCode);
		Assert.assertEquals(postStatusCode, 201);
		System.out.println("post api request PASSED");
		ResponseBody apiPostBody = apiPost.getBody();
		String jsonTOstringPOST = apiPostBody.asString();
		Assert.assertEquals(jsonTOstringPOST.contains("morpheus"), true);
		
		//validating post api using if/else statements
		if(jsonTOstringPOST.contains("morpheus"))
		{
			System.out.println("POST api request passed");
		}else {
			System.out.println("POST api request failed");
		}
		//we can also use soft assert in order to handle if there are any exception....
	}

	
}

