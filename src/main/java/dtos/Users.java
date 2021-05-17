package dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Users {
	
	private String id;
	private String email;
	private String first_name;
	private String last_name;
	private String avatar;
	private String total;
	private String name;
	private String job;
}
