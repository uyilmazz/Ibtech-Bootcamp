package com.godoro.core.utils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class StreamHelper {
	
	public static String read(InputStream in) {
		return null;
	}
	
	public static void write(OutputStream out,String output) throws IOException, UnsupportedEncodingException {
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out,"utf-8"));
		writer.write(output+"\r\n");
		writer.flush();
		out.flush();
		out.close();
		writer.close();
	}
}
