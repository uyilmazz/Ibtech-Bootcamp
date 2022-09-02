package com.ibtech.transaction.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;

public class StreamUtilities {

	public static String read(InputStream in) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in,"utf-8"));
		String line;
		StringBuilder builder = new StringBuilder();
		while((line = reader.readLine()) != null) {
			builder.append(line).append(";");
		}
		reader.close();
		String text = builder.toString();
		return text;
	}
	
	public static void write(OutputStream out,String output) throws IOException, UnsupportedEncodingException {
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out,"utf-8"));
		writer.write(output+"\r\n");
		writer.flush();
		out.flush();
		out.close();
		writer.close();
	}
	
	public static String get(String address) throws IOException  {
		URL url = new URL(address);
		URLConnection connection = url.openConnection();
		InputStream in = connection.getInputStream();
		String text = read(in);
		return text;
	}
}
