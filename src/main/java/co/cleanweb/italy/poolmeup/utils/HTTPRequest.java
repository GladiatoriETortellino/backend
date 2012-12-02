package co.cleanweb.italy.poolmeup.utils;

/**
 * HTTPRequest.java
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Simone De Cristofaro
 * @created 07/ott/2012
 */
public class HTTPRequest {
	
	/**
	 * Sends an HTTP GET request to a url
	 * 
	 * @param endpoint
	 *            - The URL of the server. (Example:
	 *            " http://www.yahoo.com/search")
	 * @param requestParameters
	 *            - all the request parameters (Example:
	 *            "param1=val1&param2=val2"). Note: This method will add the
	 *            question mark (?) to the request - DO NOT add it yourself
	 * @return - The response from the end point splitted in a string array
	 * @throws IOException 
	 */
	public static String[] sendGetRequest(String endpoint,String requestParameters) throws IOException {
		String result[] = null;
		List<String> list_result=new LinkedList<String>();
		
		if (endpoint.startsWith("http://")) {
			// Send a GET request to the servlet
			// Construct data
			StringBuffer data = new StringBuffer();

			// Send data
			String urlStr = endpoint;
			if (requestParameters != null && requestParameters.length() > 0) {
				urlStr += "?" + requestParameters;
			}
			URL url = new URL(urlStr);
			URLConnection conn = url.openConnection();

			// Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				list_result.add(line);
			}
			rd.close();
			result = new String[list_result.size()];
			list_result.toArray(result);
		}
		return result;
	}

	/**
	 * Sends an HTTP GET request to a url
	 * 
	 * @param endpoint
	 *            - The URL of the server. (Example:
	 *            " http://www.yahoo.com/search")
	 * @param requestParameters
	 *            - all the request parameters (Example:
	 *            "param1=val1&param2=val2"). Note: This method will add the
	 *            question mark (?) to the request - DO NOT add it yourself.<br>
	 *            This string must be formatted properly; e.g.: <code>findPath&voft=20&vofd=0&tdat=2012-9-25+15%3A15%3A00<code>
	 * @return - The response from the end point into a string
	 * @throws IOException 
	 */
	public static String sendGetRequestGetString(String endpoint,String requestParameters) throws IOException {
		String[] resultArray=sendGetRequest(endpoint, requestParameters);
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<resultArray.length;i++)
			sb.append(resultArray[i]);
		return sb.toString();
			
	}

	public static void main(String[]args) throws IOException {
		
		System.out.println(sendGetRequestGetString("http://www.yahoo.com/",""));
		System.out.println(sendGetRequestGetString("http://localhost:18000/dsps/","treq=findPath&voft=20&vofd=0&lspe=0&mspe=80&lnwt=0&tort=0&rtrn=0&ltrn=0&muhs=0&mdhs=0&uslo=0&dslo=0&chup=0&chdw=0&lev1=0&lev2=0&lev3=0&lev4=0&lev5=0&lev6=0&lev7=0&lev8=0&CO=0&HC=0&NOx=0&PM=0&FC=0&CO2=0&BIKEIMPEDANCE=0&PUSHBIKE=0&pxco1=16.318170595244613&pyco1=48.2325831361108&addr1=Herbeckstra%C3%9Fe+96%2C+1180+Vienna%2C+Austria+%2816.31817%2C+48.23258%29&wait1=0&pxco2=16.32288669923825&pyco2=48.233986134067145&addr2=Bastiengasse+25%2C+1180+Vienna%2C+Austria+%2816.32289%2C+48.23399%29&wait2=0&mode=car&tdes=0&tdat=2012-9-25+15%3A15%3A00&lang=ENG"));
		
	}
	
	/**
	 * Reads data from the data reader and posts it to a server via POST
	 * request. data - The data you want to send endpoint - The server's address
	 * output - writes the server's response to output
	 * 
	 * @throws Exception
	 */
	public static void postData(Reader data, URL endpoint, Writer output)
			throws Exception {
		HttpURLConnection urlc = null;
		try {
			urlc = (HttpURLConnection) endpoint.openConnection();
			try {
				urlc.setRequestMethod("POST");
			} catch (ProtocolException e) {
				throw new Exception(
						"Shouldn't happen: HttpURLConnection doesn't support POST??",
						e);
			}
			urlc.setDoOutput(true);
			urlc.setDoInput(true);
			urlc.setUseCaches(false);
			urlc.setAllowUserInteraction(false);
			urlc.setRequestProperty("Content-type", "text/xml; charset="
					+ "UTF-8");

			OutputStream out = urlc.getOutputStream();

			try {
				Writer writer = new OutputStreamWriter(out, "UTF-8");
				pipe(data, writer);
				writer.close();
			} catch (IOException e) {
				throw new Exception("IOException while posting data", e);
			} finally {
				if (out != null)
					out.close();
			}

			InputStream in = urlc.getInputStream();
			try {
				Reader reader = new InputStreamReader(in);
				pipe(reader, output);
				reader.close();
			} catch (IOException e) {
				throw new Exception("IOException while reading response", e);
			} finally {
				if (in != null)
					in.close();
			}

		} catch (IOException e) {
			throw new Exception("Connection error (is server running at "
					+ endpoint + " ?): " + e);
		} finally {
			if (urlc != null)
				urlc.disconnect();
		}
	}

	/**
	 * Pipes everything from the reader to the writer via a buffer
	 * @throws IOException 
	 */
	private static void pipe(Reader reader, Writer writer) throws IOException {
		char[] buf = new char[1024];
		int read = 0;
		while ((read = reader.read(buf)) >= 0) {
			writer.write(buf, 0, read);
		}
		writer.flush();
	}

}
