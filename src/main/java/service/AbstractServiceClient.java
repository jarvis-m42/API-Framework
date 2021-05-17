package service;

import java.util.Collections;
import java.util.function.Supplier;

import javax.ws.rs.core.GenericType;

import clients.Client;
import clients.Response;
import logging.Logging;

public abstract class AbstractServiceClient extends Client implements Logging {

	protected <T> Response call(Supplier api, GenericType<T> genericType) {
		int status = 0;
		try {
			javax.ws.rs.core.Response response = (javax.ws.rs.core.Response) api.get();
			return new Response(response.getStatus(), response.getHeaders(), response.readEntity(genericType));
		} catch (Exception e) {
			getLogger().error("Error in getting response : " + e.getMessage());
			return new Response(status, Collections.emptyMap(), e);
		}
		finally {
			target.getResteasyClient().close();
		}
	}

}
