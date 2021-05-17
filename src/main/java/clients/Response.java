package clients;

import java.util.Map;

public class Response<K> {

	private int status;
	private Map<String, String> header;
	private K payload;

	public Response(int status, Map<String, String> header, K payload) {
		this.status = status;
		this.header = header;
		this.payload = payload;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Map<String, String> getHeader() {
		return header;
	}

	public void setHeader(Map<String, String> header) {
		this.header = header;
	}

	public K getPayload() {
		return payload;
	}

	public void setPayload(K payload) {
		this.payload = payload;
	}

}
