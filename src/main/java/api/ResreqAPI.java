package api;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import dtos.Users;

public interface ResreqAPI {
	@GET
	@Path("/api/users")
	@Produces(APPLICATION_JSON)
	Response getUsersList(@QueryParam("page") Integer pageno);

	@DELETE
	@Path("api/users/{id}")
	Response deleteUser(@PathParam("id") String id);
	
	@POST
	@Path("/api/users")
	@Consumes(APPLICATION_JSON)
	@Produces(APPLICATION_JSON)
	Response createUser(Users userRequest);
	
	@PUT
	@Path("/api/users/{id}")
	@Consumes(APPLICATION_JSON)
	@Produces(APPLICATION_JSON)
	Response updateUser(@PathParam("id") String id,Users userRequest);
}
