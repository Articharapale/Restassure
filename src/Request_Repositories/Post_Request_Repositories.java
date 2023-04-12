package Request_Repositories;

import java.io.IOException;
import java.util.ArrayList;

import Common_method.get_data;

public class Post_Request_Repositories {
	
	public static String baseuri() {
		
		String baseuri="https://reqres.in/";
		return baseuri;
	}
	public static String resource()
	{
		String resource="api/users";
		return resource;
		
	}
	public static String requestbody() throws IOException
	{
		ArrayList<String> data=get_data.getdata_excel("Post_data","tc1");
		String name=data.get(2);
		String job=data.get(3);
		String requestbody="{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		return requestbody;
	}

}
