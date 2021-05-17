package util;

import static util.ExtentReportGen.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseFilter implements ClientResponseFilter {

	@Override
	public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
		test.info(MarkupHelper.createLabel(requestContext.getUri().getHost() + requestContext.getUri().getPath(),
				ExtentColor.PURPLE));

		if (requestContext.getEntity() != null) {
			test.info("<b>Request Body : </b><br>" + "<pre>" + getBody(requestContext) + "</pre>");
		}
		if (responseContext.getStatus() != 204)
			test.info("<b>Response Body : </b><br>" + "<pre>" + getText(responseContext) + "</pre>");

	}

	public String getText(ClientResponseContext responseContext) {
		try {
			InputStream is = responseContext.getEntityStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) != -1) {
				baos.write(buffer, 0, length);
			}
			responseContext.setEntityStream(new ByteArrayInputStream(baos.toByteArray()));
			String text = baos.toString().replace(",", ",<br>").replace("{", "{<br>").replace("}", "<br>}");
			return text;
		} catch (Exception e) {

		}
		return null;
	}

	public String getBody(ClientRequestContext requestContext) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String body = mapper.writer().writeValueAsString(requestContext.getEntity());

		return body.replace(",", ",<br>").replace("{", "{<br>").replace("}", "<br>}");

	}

}
