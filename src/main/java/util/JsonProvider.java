package util;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonProvider {

	public <T> Collection<? extends Object> createPOJO(String fileName, Class<T> classz)
			throws IOException, ParseException {

		ArrayList<Object> objects = new ArrayList<Object>();

		JSONParser parser = new JSONParser();

		JSONObject object = (JSONObject) parser.parse(new FileReader(fileName));

		JSONArray jsonArray = (JSONArray) object.get("testdata");

		for (int i = 0; i < jsonArray.size(); i++) {

			ObjectMapper mapper = new ObjectMapper();
			objects.add(mapper.readValue(jsonArray.get(i).toString(), classz));
		}

		return objects;
	}

	

}
