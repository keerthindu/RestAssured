
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

	@Test
	public void postRequest() {
	RestAssured.baseURI="https://reqres.in/api";
	RequestSpecification req = RestAssured.given();

	JSONObject obj = new JSONObject();
	obj.put("name", "Indu");
	obj.put("job", "SE");

	req.header("Content-Type","application/json; ");

	req.body(obj.toString());

	Response res=req.request(Method.POST,"/users");

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