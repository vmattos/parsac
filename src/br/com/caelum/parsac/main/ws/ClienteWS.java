package br.com.caelum.parsac.main.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ClienteWS {

	public String consomeWebService(String webService) throws IOException {

		URL url = new URL(webService);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		StringBuilder builder = getBuilder(connection);

		String xml = builder.toString();

		return xml;
	}

	private StringBuilder getBuilder(HttpURLConnection connection)
			throws IOException {

		InputStream content = connection.getInputStream();
		InputStreamReader reader = new InputStreamReader(content);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String s = bufferedReader.readLine();
		StringBuilder builder = new StringBuilder();
		while (s != null) {
			builder.append(s).append("\n");
			s = bufferedReader.readLine();
		}
		bufferedReader.close();

		return builder;
	}
}