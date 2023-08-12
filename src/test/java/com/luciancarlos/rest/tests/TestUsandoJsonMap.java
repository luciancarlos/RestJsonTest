package com.luciancarlos.rest.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.luciancarlos.rest.core.JsonToMap;

public class TestUsandoJsonMap {

	@Test
	public void usingJsonMapTestJackson() {
		String json = "{\r\n"
				+ "    \"id\": \"99\",\r\n"
				+ "    \"name\": \"Lucian\",\r\n"
				+ "    \"job\": \"QA\",\r\n"
				+ "    \"createdAt\": \"2023-08-12T20:03:38.763Z\"\r\n"
				+ "}";
		
		Map<String, String> map = new HashMap<>();
		map = JsonToMap.getJsonAsMap(json, "String", "a");
		map.put("testeKey", "VALOR");
		
		
		//printing map
		System.out.println(map);
		System.out.println(map.get("testeKey"));
		System.out.println(map.getOrDefault("id", json));		
		System.out.println(map.getOrDefault("name", json));		
		System.out.println(map.getOrDefault("job", json));		
		System.out.println(map.getOrDefault("NaoExiste", "NAO TEM"));		
	}
	
	@Test
	public void usingJsonMapTestGson() {
		String json = "{\r\n"
				+ "    \"name\": \"Lucian\",\r\n"
				+ "    \"job\": \"QA\",\r\n"
				+ "    \"id\": \"521\",\r\n"
				+ "    \"createdAt\": \"2023-08-12T21:03:38.763Z\"\r\n"
				+ "}";
		
		HashMap<String,String> map = new Gson().fromJson(json, new TypeToken<HashMap<String, String>>(){}.getType());
		
		System.out.println(map);
	}

	@Test
	public void usingJsonMapFromFile() {
		File file = new File("C:\\Projetos\\CursoRest\\target\\teste2.json");
		
		Map<String, Object> map = new HashMap<>();
		try {
			map = JsonToMap.JsonMapFromFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JSONObject request = new JSONObject(map);
		
		System.out.println(request.toJSONString());		
	}
}