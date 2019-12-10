import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_Request1 {

	@Test
	void googlemap()
	{
		//specify base url
		
		RestAssured.baseURI="https://maps.googleapis.com";
		
		//Request object
		RequestSpecification httprequest=RestAssured.given();
		
		//Response object
		Response response=httprequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4IgTqSTDmHmJ2HoELb4Jy1s");
		
		String responsebody=response.getBody().asString();
		System.out.println("response body is:"+responsebody);
		
		//capture details of headers from response
		
		String contentEncoding=response.header("Content-Encoding");
		System.out.println("content contentEncoding is;"+contentEncoding);
		Assert.assertEquals(contentEncoding, "gzip");
		
	}
}

