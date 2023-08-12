package com.luciancarlos.rest.core;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToMap {
	public static <K extends Object, V extends Object> Map<K, V> getJsonAsMap(String json, K key, V value) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<Map<K, V>> typeRef = new TypeReference<Map<K, V>>() {
			};
			return mapper.readValue(json, typeRef);
		} catch (Exception e) {
			throw new RuntimeException("Couldnt parse json:" + json, e);
		}
	}
	
	public static <K extends Object, V extends Object> HashMap<String, Object> JsonMapFromFile(File file) throws JsonParseException, JsonMappingException, IOException {
		
		HashMap<String,Object> props;
				
		// src is a File, InputStream, String or such
		props = new ObjectMapper().readValue(file, new TypeReference<HashMap<String,Object>>() {});

//		// or:
//		props = (HashMap<String,Object>) new ObjectMapper().readValue(file, HashMap.class);		
		
		return props;
	}
}