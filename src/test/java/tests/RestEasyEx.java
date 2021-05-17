package tests;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import tests.base.BaseTest;

public class RestEasyEx extends BaseTest {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		//This class is for practice purpose
		
		
		/*
		 * //First Define a URL for the API final String path = "https://reqres.in/";
		 * 
		 * //2. Create a Client Object to process HTTP request ResteasyClient
		 * client=(ResteasyClient) ClientBuilder.newClient();
		 * 
		 * //3. Give target URL to client object, User ResteasyWebTarget because it give
		 * you proxy method ResteasyWebTarget target = (ResteasyWebTarget)
		 * client.target(UriBuilder.fromPath(path));
		 * 
		 * //4. User interface in proxy method so it will add all metadata from
		 * anotations mention inside interface UserAPI proxy =
		 * target.proxy(UserAPI.class);
		 * 
		 * //5. now here it will execure URL + path mentioned for method inside
		 * interface Response users= proxy.getUsersList(2);
		 * 
		 * //6. Read entity method returns response body UserList
		 * user=users.readEntity(UserList.class);
		 * 
		 * System.out.println("Email : "+user.getData().get(1).getEmail());
		 * 
		 * //Read Json and Map to the POJO
		 * 
		 * ObjectMapper mapper= new ObjectMapper();
		 * 
		 * Users newUser=mapper.readValue(new File("data.json"), Users.class);
		 * 
		 * Response createUser=proxy.createUser(newUser);
		 * 
		 * System.out.println("Job : "+createUser.readEntity(Users.class).getJob());
		 */
		
	}


}
