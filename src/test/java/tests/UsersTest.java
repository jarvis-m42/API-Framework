package tests;

import static org.hamcrest.CoreMatchers.is;
import static org.jboss.resteasy.util.HttpResponseCodes.SC_CREATED;
import static org.jboss.resteasy.util.HttpResponseCodes.SC_OK;

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
import dtos.UserList;
import dtos.Users;
import tests.base.BaseTest;
import util.JsonProvider;

public class UsersTest extends BaseTest {

	@Test
	public void getUserList() throws JsonProcessingException {
		Response<UserList> usersResponse = service().resreqService().getUsersList(2);
		checkStatusCode(usersResponse.getStatus(), is(SC_OK));
	}

	@Test
	@UseDataProvider("createUserDataProvider")
	public void createUser(Users user) throws JsonParseException, JsonMappingException, IOException {
		Response<Users> createUser = service().resreqService().createUser(user);

		checkStatusCode(createUser.getStatus(), is(SC_CREATED));

		checkThat("Verify User name : ", createUser.getPayload().getName(), is(user.getName()));
		checkThat("Verify job : ", createUser.getPayload().getJob(), is(user.getJob()));
	}

	@DataProvider
	public static Collection<? extends Object> createUserDataProvider() throws IOException, ParseException {
		return new JsonProvider().createPOJO("resources/data2.json", Users.class);
	}

}
