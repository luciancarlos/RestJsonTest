package com.luciancarlos.rest.tests;

import org.json.simple.JSONObject;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetAndPostExemplos {

	@Test
	public void testGet() {
		baseURI = "https://reqres.in/api";
		
		given()
			.get("/users?page=2")
		.then()
			.statusCode(200)
			.body("data[4].first_name", equalTo("George"))
			.body("data.first_name", hasItems("George","Rachel"))
		;
	}
	
	@Test
	public void testMap() {
		baseURI = "https://reqres.in/api";
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("name", "Lucian");
		map.put("job", "QA");
		
		System.out.println(map);
	}

	
	@Test
	public void testPostJSONObject() {
		baseURI = "https://reqres.in/api";
		
		Map<String, Object> map = new HashMap<>();

		JSONObject request = new JSONObject();
		
		request.put("name", "Lucian");
		request.put("job", "QA");
		
//		System.out.println(request.toJSONString());
		given()
			.header("Content-Type","application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request)
			.when()
				.post("/users")
			.then()
				.statusCode(201)
				.log().all()
			;
	}
	
	@Test
	public void testPostGson() {
		baseURI = "https://reqres.in/api";
		
		Gson gson = new Gson();

		Map<String, Object> map = new HashMap<>();
		
		map.put("name", "Lucian");
		map.put("job", "QA");
		
		// convert map to JSON String
        String jsonStr = gson.toJson(map);

        System.out.println(jsonStr);
		
		given()
			.header("Content-Type","application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(jsonStr)
			.when()
				.post("/users")
			.then()
				.statusCode(201)
				.log().all()
			;
	}
	
	@Test
	public void testPostJackson() {
		baseURI = "https://reqres.in/api";
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("name", "Lucian");
		map.put("job", "QA");

		ObjectMapper mapper = new ObjectMapper();
		
		String json = null;
		try {
			json = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		System.out.println(json);
	
		given()
			.header("Content-Type","application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(json)
			.when()
				.post("/users")
			.then()
				.statusCode(201)
				.log().all()
			;
	}
}
