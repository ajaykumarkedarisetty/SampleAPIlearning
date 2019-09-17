package com.qa.Client;

import java.io.IOException;
import java.util.HashMap;
import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {


	// 1. Creating the GET method
	public  CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {

		// this is abstract class, it is creating simple http client
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// Creating the httpget-> means which url has to hit
		HttpGet httpget = new HttpGet(url);
		// Used to execute the script, Fetching the complete response
		CloseableHttpResponse closablehttpresponse = httpclient.execute(httpget);

		return closablehttpresponse;
	}
}
