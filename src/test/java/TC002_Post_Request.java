
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;

import Base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_Post_Request {
	
	BaseClass base;
	String endpoint;
	String param;
	
	@BeforeTest
	public void setup() throws Exception {
		base = new BaseClass();
		endpoint = base.pro.getProperty("entry");
		param = base.pro.getProperty("create");
		System.out.println(endpoint+param);
			
	}
	
	@Test
	public void postRequest() {
	RestAssured.baseURI=endpoint;
	RequestSpecification req = RestAssured.given();
	
	JSONObject obj = new JSONObject();
	obj.put("name", "Indu");
	obj.put("job", "SDET");
	obj.put("id", "487");
	obj.put("mail", "induindu@gmail.com");
	
	req.header("Content-Type","application/json; ");
	
	req.body(obj.toString());
	
	Response res=req.request(Method.POST,param);
	
	//print response
	
	String body = res.body().asPrettyString();
	System.out.println(body);
	
	//status code
	int code = res.statusCode();
	System.out.println("STATUS CODE : "  +code);
	
	String msg = res.statusLine();
	System.out.println("MESSAGE" +msg);

}
}