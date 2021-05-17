package clients;

import java.io.InputStream;
import java.util.Map;

import javax.ws.rs.client.ClientBuilder;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.yaml.snakeyaml.Yaml;

import util.ResponseFilter;

public abstract class Client {
	
	public static ResteasyWebTarget target;
	protected <T> T getProxy(String name, Class<T> classz) {
		target= (ResteasyWebTarget) ClientBuilder.newBuilder().register(new ResponseFilter()).build().target(getURL(name));
		return target.proxy(classz);
	}

	private String getURL(String name) {
		Yaml yaml = new Yaml();
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("application.yml");
		Map<String, Object> obj = yaml.load(inputStream);
		return obj.get(name).toString();
	}

}
