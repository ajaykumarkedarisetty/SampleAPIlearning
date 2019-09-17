package com.qa.testoutput;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.qa.BaseClass.TestBase;
import com.qa.Client.RestClient;

public class GetAPITest extends TestBase {

	TestBase testbase;
	String serviceUrl;
	String apiurl;
	String FinalURl;
	RestClient restclient;
	CloseableHttpResponse closablehttpresponse;

	@BeforeTest
	public void setUp() {
		testbase = new TestBase();
		serviceUrl = prop.getProperty("BaseURL");
		apiurl = prop.getProperty("ServiceURL");
		FinalURl = serviceUrl + apiurl;
	}
	
	@Test
	public void case1() throws ClientProtocolException, IOException {
	
		restclient = new RestClient();
		closablehttpresponse = restclient.get(FinalURl); 
		
		// Getting status code from the status line
				int statuscode = closablehttpresponse.getStatusLine().getStatusCode();
				System.out.println("Status code--->" + statuscode);

				Assert.assertEquals(statuscode, 200, "Status code is not 200");
				
				
				String responseString = EntityUtils.toString(closablehttpresponse.getEntity(), "UTF-8");

				// Used to convert the string to complete Json
				JSONObject responsejson = new JSONObject(responseString);
				System.out.println("Response Json--" + responsejson);
				
				// Fetching the Headers from the response
				Header[] headerArray = closablehttpresponse.getAllHeaders();
				// Creating the Hashmap
				HashMap<String,String> allheaders = new HashMap<String,String>();
				for(Header header : headerArray) {
					allheaders.put(header.getName(), header.getValue());
				}
				System.out.println("Headers-->"+allheaders);

	}

}
