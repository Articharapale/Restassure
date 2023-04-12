package Common_method;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class evidence_filecreator {
	
	public static void evidencefile_creator(String filename,String request,String response) throws IOException
	{
		File newtextfile=new File("C:\\Users\\BANGLADESH\\Desktop\\Rest Assured\\" +filename+ ".txt");
		if(newtextfile.createNewFile())
		{
		FileWriter datawriter=new FileWriter(newtextfile);
		datawriter.write("Request body: \n\n" +request+ "\n");
		datawriter.write("Responsebody is: \n\n" +response);
		datawriter.close();
		System.out.println("Requestbody and Responsebody saved is:" +newtextfile.getName());
		}
		else
		{
			System.out.println(newtextfile.getName()+"Allready file saved plaese take a backup");
		}
		
	}

}
