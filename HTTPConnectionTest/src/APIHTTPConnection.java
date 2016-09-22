

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * 
 */

/**
 * @author lkandasa
 *
 */
public class APIHTTPConnection {

	
	// HTTP GET request
	public static String sendGet(String token, String urlString) throws Exception {

		if (urlString.startsWith("http:")) {
			return doSendHttpGetRequest(urlString, token);
		} else {
			return doSendHttpsGetRequest(urlString, token);
		}

	}

	private static String doSendHttpsGetRequest(String urlString, String token) throws IOException {
		// String url = urlString;

		SSLTool.disableCertificateValidation();
		// SSLSocketFactory sslsocketfactory = (SSLSocketFactory)
		// SSLSocketFactory.getDefault();
		URL url = null;
		try {
			url = new URL(urlString);
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
		HttpsURLConnection conn = null;
		try {
			conn = (HttpsURLConnection) url.openConnection();
		} catch (IOException e) {

			e.printStackTrace();
		}
		conn.setRequestProperty("X-Cloupia-Request-Key", token);
		try {
			conn.setRequestMethod("GET");
		} catch (ProtocolException e1) {

			e1.printStackTrace();
		}
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int responseCode = conn.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		// System.out.println("\nSending 'GET' request to URL : " + url);
		// System.out.println("Response Code : " + responseCode);
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		conn.disconnect();
		// print result
		System.out.println(response.toString());
		return responseCode + "#" + response.toString();
	}

	private static String doSendHttpGetRequest(String urlString, String token) throws Exception {
		String url = urlString;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestProperty("X-Cloupia-Request-Key", token);
		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		// con.setRequestProperty("User-Agent", USER_AGENT);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());
		return responseCode + "#" + response.toString();
	}

	// HTTP POST request
	public static String sendPost(String token, String urlString, String urlParameters) throws Exception {

		// String url = urlString;

		SSLTool.disableCertificateValidation();
		// SSLSocketFactory sslsocketfactory = (SSLSocketFactory)
		// SSLSocketFactory.getDefault();
		URL url = null;
		try {
			url = new URL(urlString);
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
		HttpsURLConnection conn = null;
		try {
			conn = (HttpsURLConnection) url.openConnection();

		} catch (IOException e) {
			System.out.println(url.toString());
			e.printStackTrace();
		}
		conn.setRequestProperty("X-Cloupia-Request-Key", token);
		try {
			conn.setRequestMethod("POST");
		} catch (ProtocolException e1) {

			e1.printStackTrace();
		}
		// conn.setSSLSocketFactory(co);

		conn.setDoInput(true);
		conn.setDoOutput(true);
		DataOutputStream wr = null;
		try {
			wr = new DataOutputStream(conn.getOutputStream());

			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		InputStream inputstream = null;
		try {
			inputstream = conn.getInputStream();
		} catch (IOException e) {

			e.printStackTrace();
		}

		int responseCode = -1;
		try {
			responseCode = conn.getResponseCode();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = null;
		String inputLine = null;

		StringBuffer response = new StringBuffer();
		try {
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		conn.disconnect();
		return responseCode + "#" + response.toString();
	}

	// HTTP POST request
	public static String sendPost(String token, String urlString, String urlParameters, int readTimeOut)
			throws Exception {

		// String url = urlString;

		SSLTool.disableCertificateValidation();
		// SSLSocketFactory sslsocketfactory = (SSLSocketFactory)
		// SSLSocketFactory.getDefault();
		URL url = null;
		try {
			url = new URL(urlString);
		} catch (MalformedURLException e) {

			e.printStackTrace();
		}
		HttpsURLConnection conn = null;
		try {
			conn = (HttpsURLConnection) url.openConnection();

		} catch (IOException e) {
			System.out.println(url.toString());
			e.printStackTrace();
		}
		conn.setRequestProperty("X-Cloupia-Request-Key", token);
		conn.setReadTimeout(readTimeOut);
		try {
			conn.setRequestMethod("POST");
		} catch (ProtocolException e1) {

			e1.printStackTrace();
		}
		// conn.setSSLSocketFactory(co);

		conn.setDoInput(true);
		conn.setDoOutput(true);
		DataOutputStream wr = null;
		try {
			wr = new DataOutputStream(conn.getOutputStream());

			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			Thread.sleep(readTimeOut);
		} catch (Exception e) {
			e.printStackTrace();
		}

		InputStream inputstream = null;
		try {
			inputstream = conn.getInputStream();
		} catch (IOException e) {

			e.printStackTrace();
		}

		int responseCode = -1;
		try {
			responseCode = conn.getResponseCode();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = null;
		String inputLine = null;

		StringBuffer response = new StringBuffer();
		try {
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		conn.disconnect();
		System.out.println("Response Code : " + response.toString());

		return responseCode + "#" + response.toString();
	}

}
