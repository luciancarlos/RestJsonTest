package com.luciancarlos.rest.core;

import io.restassured.http.ContentType;


public interface Constantes {
	String APP_BASE_URL = "https://barrigarest.wcaquino.me";
	Integer APP_PORT = 443; // http -> 80
	String APP_BASE_PATH = ""; //(ex: /v1,)
	
	ContentType APP_CONTENT_TYPE = ContentType.JSON;
	
	Long MAX_TIMEOUT = 5000L; //(tempo maximo que cada request deve responder) 	
	
}
