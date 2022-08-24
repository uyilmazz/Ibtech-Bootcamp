package com.godoro.io;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ResourceTest {

	public static void main(String[] args) {
		
		String path = "C:\\Users\\Unal\\Desktop\\java\\Ibtech\\out.txt";
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
			bw.write("Java\r\n");
			bw.write("JDBC\r\n");
			bw.write("JAXP\r\n");
			bw.write("JSON-P\r\n");
			bw.write("JSON");
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
