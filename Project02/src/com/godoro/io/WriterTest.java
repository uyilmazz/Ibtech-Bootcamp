package com.godoro.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterTest {

	public static void main(String[] args) throws IOException {
		
		String path = "C:\\Users\\Unal\\Desktop\\java\\Ibtech\\out.txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(path));
		
		bw.write("Java\r\n");
		bw.write("JDBC\r\n");
		bw.write("JAXP\r\n");
		bw.write("JSON-P\r\n");
		bw.write("JSON");
		
		bw.close();
	}
}
