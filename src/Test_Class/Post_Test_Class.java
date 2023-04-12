package Test_Class;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common_method.Post_Common_method;
import Common_method.evidence_filecreator;
import Request_Repositories.Post_Request_Repositories;
import io.restassured.path.json.JsonPath;

public class Post_Test_Class {
	@Test
	public static void orchestrator() throws IOException
	{
		String responsebody="";
		int responsestatuscode=0;
		String baseuri=Post_Request_Repositories.baseuri();
		String resource=Post_Request_Repositories.resource();
		String requestbody=Post_Request_Repositories.requestbody();
		
		for(int i=0;i<5;i++)
		{
			responsestatuscode=Post_Common_method.responsesatuscode(baseuri, resource, requestbody);
			if(responsestatuscode==201)
			{
				responsebody=Post_Common_method.responsebodyr(baseuri, resource, requestbody);
				responsebodyValidtaor(responsebody);
				break;
			}
			
		}
		evidence_filecreator.evidencefile_creator("Post_Test_Class", requestbody, responsebody);
		Assert.assertEquals(responsestatuscode, 201);
	}	
public static void responsebodyValidtaor(String responsebody)
{
	
	JsonPath obj=new JsonPath(responsebody);
	
	String res_name=obj.getString("name");
	System.out.println(res_name);
	String res_job=obj.getString("job");
	System.out.println(res_job);
	String res_id=obj.getString("id");
	System.out.println(res_id);
	String res_createdAt=obj.getString("createdAt");
	System.out.println(res_createdAt);
	
	Assert.assertEquals(res_name,"morpheus");
	Assert.assertEquals(res_job,"leader");
    Assert.assertNotNull("id");
    
    String Date=new String(res_createdAt);
    System.out.println(Date.substring(0,10));
    
    String result=new String(Date);
    System.out.println(result.substring(0,10));
    
    Assert.assertEquals(Date, result);
	
	}
}
