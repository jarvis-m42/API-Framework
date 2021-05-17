package service.resreq;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericType;

import api.ResreqAPI;
import clients.Response;
import dtos.UserList;
import dtos.Users;
import service.AbstractServiceClient;

public class ResReqService extends AbstractServiceClient {

	public ResreqAPI resreqApi;
	
	{
		resreqApi = getProxy("resreq", ResreqAPI.class);
	}

	public Response<UserList> getUsersList(int pageno) {
		return call(() -> resreqApi.getUsersList(pageno), new GenericType<UserList>() {
		});
	}

	public Response<Users> createUser(Users userRequest) {
		return call(() -> resreqApi.createUser(userRequest), new GenericType<Users>() {
		});
	}

	public Response<Users> deleteUser(@PathParam("id") String id) {
		return call(() -> resreqApi.deleteUser(id), new GenericType<Users>() {
		});
	}

	public Response<Users> updateUser(@PathParam("id") String id, Users userRequest) {
		return call(() -> resreqApi.updateUser(id, userRequest), new GenericType<Users>() {
		});
	}
}
