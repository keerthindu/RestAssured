

import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;


public class TC001_GetRequest  {

	@Test
	void getDetails()  {
		
		RestAssured.baseURI="https://reqres.in/api/users";
		RequestSpecification req = RestAssured.given();
		Response res = req.request(Method.GET,"/2");
		
		//Response body validation
		String body = res.getBody().asPrettyString();
		System.out.println("Response Body is" + body);
		
		//status code validation
		int statuscode = res.getStatusCode();
		System.out.println("STATUS CODE" +statuscode);
		Assert.assertEquals(200, statuscode);
		
		//status line validation
		String statusmsg =  res.getStatusLine();
		System.out.println("Status Line is:" +statusmsg);
		Assert.assertEquals("HTTP/1.1 200 OK", statusmsg);

		//Header validation
		String contentType = res.header("Content-Type");
		System.out.println("Header is" + contentType);
		Assert.assertEquals("application/json; charset=utf-8",contentType);

		//print all headers
//		String headers = res.getHeaders().toString();
		Headers allheads = res.getHeaders();

		for(Header head : allheads){
			System.out.println(head.getName()+ "       " + head.getValue());
		}


	
	}

}
