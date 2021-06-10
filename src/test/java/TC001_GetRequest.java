import java.io.FileNotFoundException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;


public class TC001_GetRequest  {
	BaseClass base;
	String endpoint;
	String param;
	String epoint;
	
	@BeforeTest
	public void setup() throws Exception {
		base=new BaseClass();
		  endpoint = base.pro.getProperty("url");
		System.out.println(endpoint);
		 param = base.pro.getProperty("parameter");
		System.out.println(param);
		
		 epoint = endpoint+param;
		System.out.println(epoint);
		
	}
	
	
	@Test
	void getDetails()  {
		
		RestAssured.baseURI=endpoint;
		RequestSpecification req = RestAssured.given();
		Response res = req.request(Method.GET,param);
		
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
	
	}

}
