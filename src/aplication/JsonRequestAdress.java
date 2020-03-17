package aplication;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JsonRequestAdress {

	public static String request( String uri ) throws Exception {

		
		//String url = "https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=3f78fe89cf683b6fcd8670de2261d11db3e869fe";
		URL url = new URL( uri );
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		InputStream in = new BufferedInputStream(urlConnection.getInputStream());
		BufferedReader r = new BufferedReader(new InputStreamReader(in));

		StringBuilder jsonString = new StringBuilder();
		String line;
		while ((line = r.readLine()) != null) {
		jsonString.append(line);
		}

		urlConnection.disconnect();

		return jsonString.toString();
		}

}
