package Common_method;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given; 
public class Post_Common_method {
	
	public static int responsesatuscode(String baseuri,String resource,String requestbody)
	{
		RestAssured.baseURI=baseuri;
		int responsesatuscode=given().header("Content-Type","application/json").body(requestbody).
				         when().post(resource).then().extract().statusCode();
		return responsesatuscode;	
	}
	
	public static String responsebodyr(String baseuri,String resource,String requestbody)
	{
		RestAssured.baseURI=baseuri;
		String responsebody=given().header("Content-Type","application/json").body(requestbody).
				         when().post(resource).then().extract().response().asString();
		return responsebody;	
	}

}
