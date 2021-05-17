package tests;

import static org.hamcrest.CoreMatchers.is;
import static org.jboss.resteasy.util.HttpResponseCodes.SC_CREATED;
import static org.jboss.resteasy.util.HttpResponseCodes.SC_NO_CONTENT;

import java.io.IOException;
import java.util.Collection;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import clients.Response;
import dtos.Users;
import tests.base.BaseTest;
import util.JsonProvider;;

public class NewTests extends BaseTest {

	@Test
	public void deleteUser() throws JsonProcessingException {
		Response<Users> usersResponse = service().resreqService().deleteUser("3");
		checkStatusCode(usersResponse.getStatus(), is(SC_NO_CONTENT));
	}

	@Test
	@UseDataProvider("updateUserDataProvider")
	public void updateUser(Users user) throws JsonParseException, JsonMappingException, IOException {
		Response<Users> updateUser = service().resreqService().createUser(user);
		checkStatusCode(updateUser.getStatus(), is(SC_CREATED));
		checkThat("Verify User name",updateUser.getPayload().getName(), is(user.getName()));
	}

	@DataProvider
	public static Collection<? extends Object> updateUserDataProvider() throws IOException, ParseException {
		return new JsonProvider().createPOJO("resources/update.json", Users.class);
	}
}
