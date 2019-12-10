package com_edl_api_testing;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.testng.annotations.BeforeClass;
//import org.apache.log4j.Level;

import org.apache.log4j.PropertyConfigurator;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
public static RequestSpecification httpRequest;
public static Response response;
public String shareclass="";

public  Logger logger;

@BeforeClass
public void setup() {
	logger=Logger.getLogger("EDLRestAPI");
	PropertyConfigurator.configure("Log4j.properties");
	logger.setLevel(Level.WARNING);
}
}
